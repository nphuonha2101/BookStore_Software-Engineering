package com.software.bookstore.vnpay;

import com.software.bookstore.utils.Decrypt;
import com.software.bookstore.utils.Files;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class VNPay {
    private final Map<String, Object> vnp_Params;
    private static VNPay instance;

    private VNPay() {
        vnp_Params = new HashMap<>();
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TmnCode = Files.env("vnp.tmnCode");
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_OrderType", "190000");
        vnp_Params.put("vnp_ReturnUrl", Files.env("vnp.returnUrl"));
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        // expiry after 15 minutes
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        vnp_Params.put("vnp_Locale", "vn");
    }

    public static VNPay init() {
        if (instance == null) {
            instance = new VNPay();
        }
        return instance;
    }

    /**
     * Add amount of this payment to vnp_Params
     * @param amount   amount of this payment
     * @return {@link VNPay} to chain
     */
    public VNPay addAmount(double amount) {
        int intAmount = (int) amount * 100;
        vnp_Params.put("vnp_Amount", String.valueOf(intAmount));
        return this;
    }

    /**
     * Add transaction reference to vnp_Params
     * <br>
     * This is a unique reference for this transaction
     * <br>
     * If transaction successful, the current vnp_TxnRef is cannot be used again
     * @param vnp_TxnRef  transaction reference
     * @return {@link VNPay} to chain
     */
    public VNPay addTxnRef(String vnp_TxnRef) {
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        return this;
    }

    /**
     * Add order info to vnp_Params
     * @param orderInfo order info
     * @return {@link VNPay} to chain
     */
    public VNPay addOrderInfo(String orderInfo) {
        vnp_Params.put("vnp_OrderInfo", orderInfo);
        return this;
    }

    /**
     * Add customer IP to vnp_Params
     * @param req  request to get customer IP
     * @return {@link VNPay} to chain
     */
    public VNPay addCustomerIP(HttpServletRequest req) {
        String customerIP = req.getRemoteAddr();
        vnp_Params.put("vnp_IpAddr", customerIP);
        return this;
    }


    /**
     * Get payment URL from vnp_Params
     * @return payment URL
     */
    public String getPaymentURL() {
        List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator<String> itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (!fieldValue.isEmpty())) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Decrypt.hmacSha512(Files.env("vnp.hashSecret"), hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;

        return Files.env("vnp.url") + "?" + queryUrl;
    }
}

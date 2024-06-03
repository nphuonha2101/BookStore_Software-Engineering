package com.software.bookstore.http.controllers.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.http.enums.PaymentMethod;
import com.software.bookstore.http.enums.PaymentStatus;
import com.software.bookstore.http.models.Payment;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.response.JsonFactory;
import com.software.bookstore.http.services.CartDetailService;
import com.software.bookstore.http.services.PaymentService;
import com.software.bookstore.utils.SessionAlert;
import com.software.bookstore.vnpay.VNPay;

@WebServlet("/checkout/vnpay")
public class VnpayPaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vnpResponseCode = req.getParameter("vnp_ResponseCode");
        HttpSession session = req.getSession();

        // Payment success
        if (vnpResponseCode.equals("00")) {
            double total = Double.parseDouble(req.getParameter("vnp_Amount")) / 100;
            User loginUser = (User) session.getAttribute("loginUser");

            if (loginUser == null) {
                String json = new JsonFactory.Unauthorized().build();
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, json);
                return;
            }

            Payment payment = new Payment();
            payment.setUserId(loginUser.getId());
            payment.setCartId(loginUser.getCart().getId());
            payment.setTotal(total);
            payment.setPaymentMethod(PaymentMethod.VNPAY);
            payment.setPaymentStatus(PaymentStatus.SUCCESS);

            payment = new PaymentService().save(payment);

            if (payment == null) {
                SessionAlert.setMessage(session, "Thanh toán thất bại", "danger");
            } else {
                boolean isDelete = new CartDetailService().deleteByCartId(loginUser.getCart().getId());
                if (isDelete)
                    SessionAlert.setMessage(session,
                            "Thanh toán thành công, chúng tôi sẽ gửi hàng cho bạn sớm nhất có thể. Xin cảm ơn!",
                            "success");
                else
                    SessionAlert.setMessage(session, "Thanh toán thất bại", "danger");
            }
        }

        // Payment failed
        else
            SessionAlert.setMessage(session, "Thanh toán thất bại", "danger");

        resp.sendRedirect("/cart");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double total = Double.parseDouble(req.getParameter("total"));
        String vnpTxnRef = String.valueOf(Math.round(System.currentTimeMillis() * Math.random() * 1000));

        String paymentUrl = VNPay.init()
                .addAmount(total)
                .addOrderInfo("Thanh toán đơn hàng")
                .addCustomerIP(req)
                .addTxnRef(vnpTxnRef)
                .getPaymentURL();

        resp.sendRedirect(paymentUrl);
    }
}

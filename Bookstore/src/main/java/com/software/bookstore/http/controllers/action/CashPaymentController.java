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

@WebServlet("/checkout/cash")
public class CashPaymentController extends HttpServlet {

    private final PaymentService paymentService = new PaymentService();
    private final CartDetailService cartDetailService = new CartDetailService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            String json = new JsonFactory.Unauthorized().build();
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, json);
            return;
        }

        double total = Double.parseDouble(req.getParameter("total"));
        Payment payment = new Payment();
        payment.setUserId(loginUser.getId());
        payment.setCartId(loginUser.getCart().getId());
        payment.setPaymentMethod(PaymentMethod.CASH);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setTotal(total);
        payment = paymentService.save(payment);
        if (payment == null) {
            SessionAlert.setMessage(session, "Thanh toán thất bại", "danger");
        } else {
            boolean isDelete = cartDetailService.deleteByCartId(loginUser.getCart().getId());
            if(isDelete)
                SessionAlert.setMessage(session,
                    "Thanh toán thành công, chúng tôi sẽ gửi hàng cho bạn sớm nhất có thể, vui lòng chuẩn bị tiền mặt",
                    "success");
            else 
                SessionAlert.setMessage(session, "Thanh toán thất bại", "danger");
        }

        resp.sendRedirect("/cart");
    }
}

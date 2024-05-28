package com.software.bookstore.http.controllers.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.utils.SessionAlert;

@WebServlet("/checkout/vnpay")
public class VnpayPaymentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SessionAlert.setMessage(session, "Tính năng này hiện vẫn đang được phát triển", "warning");
        resp.sendRedirect("/cart");
    }
}

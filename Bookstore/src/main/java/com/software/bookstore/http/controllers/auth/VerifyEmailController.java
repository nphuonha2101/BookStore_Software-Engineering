package com.software.bookstore.http.controllers.auth;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.http.models.VerifyEmail;
import com.software.bookstore.http.services.VerifyEmailService;

@WebServlet("/verify-email")
public class VerifyEmailController extends HttpServlet {

    private final VerifyEmailService verifyEmailService = new VerifyEmailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        if(token == null) {
            resp.sendError(403, "Token không hợp lệ");
            return;
        }
        VerifyEmail verifyEmail = verifyEmailService.findByToken(token);
        if(verifyEmail == null) {
            resp.sendError(403, "Token không hợp lệ");
            return;
        }

        Timestamp expires = verifyEmail.getExpires();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if(now.after(expires)) {
            verifyEmailService.delete(verifyEmail.getId());
            resp.sendError(403, "Token đã hết hạn");
            return;
        }
        verifyEmailService.delete(verifyEmail.getId());
        resp.sendRedirect("/home");
    }
}

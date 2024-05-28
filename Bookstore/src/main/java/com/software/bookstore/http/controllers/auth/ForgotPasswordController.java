package com.software.bookstore.http.controllers.auth;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.http.models.ForgotPassword;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.ForgotPasswordService;
import com.software.bookstore.http.services.UserSerivce;
import com.software.bookstore.mail.Mail;
import com.software.bookstore.utils.Decrypt;
import com.software.bookstore.utils.Files;
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/auth/forgot")
public class ForgotPasswordController extends HttpServlet {

    private final UserSerivce userSerivce = new UserSerivce();
    private final ForgotPasswordService forgotPasswordService = new ForgotPasswordService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User user = userSerivce.findByEmail(email);
        HttpSession session = req.getSession();
        if (user != null) {
            String hashData = user.getId() + user.getEmail() + user.getFullName() + System.currentTimeMillis() + "";
            String token = Decrypt.sha256(hashData);
            Timestamp expires = new Timestamp(System.currentTimeMillis() + 3 * 60 * 1000);
            ForgotPassword forgotPassword = new ForgotPassword();
            forgotPassword.setUserId(user.getId());
            forgotPassword.setToken(token);
            forgotPassword.setExpires(expires);
            boolean isDelete = forgotPasswordService.deleteByUserId(user.getId());
            if (isDelete) {
                forgotPassword = forgotPasswordService.save(forgotPassword);
            }
            if (forgotPassword != null) {
                String host = Files.env("app.host");
                String mailContent = host + "/reset-password?token=" + token;
                Mail.sendTo(email, "Lấy lại mật khẩu", mailContent, "text/html");
                SessionAlert.setMessage(session, "Vui lòng kiểm tra email để lấy mật khẩu mới", "success");
            } else {
                SessionAlert.setMessage(session, "Đã có lỗi xảy ra, vui lòng thử lại sau", "danger");
            }
            resp.sendRedirect("/forgot-password");
        } else {
            SessionAlert.setMessage(session, "Không tìm thấy email đăng ký", "danger");
            resp.sendRedirect("/forgot-password");
        }
    }
}

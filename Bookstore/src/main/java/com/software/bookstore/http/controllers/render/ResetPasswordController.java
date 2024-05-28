package com.software.bookstore.http.controllers.render;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.models.ForgotPassword;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.ForgotPasswordService;
import com.software.bookstore.http.services.UserSerivce;
import com.software.bookstore.utils.Decrypt;
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/reset-password")
public class ResetPasswordController extends HttpServlet {

    private final ForgotPasswordService forgotPasswordService = new ForgotPasswordService();
    private final UserSerivce userSerivce = new UserSerivce();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        if(token == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ForgotPassword forgotPassword = forgotPasswordService.findByToken(token);
        if(forgotPassword == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        APage page = new ClientPage(req, resp, "reset.jsp", "blank.jsp");
        Timestamp expires = forgotPassword.getExpires();
        if(isExpired(expires)) {
            forgotPasswordService.deleteByToken(token);
            page.setTitle("Đã hết hạn");
            page.setObject("isExpired", true);
            page.render();
            return;
        }

        String[] messageAlert = SessionAlert.getMessage(req.getSession());

        page.setTitle("Đặt lại mật khẩu");
        page.setObject("message", messageAlert[0]);
        page.setObject("alertType", messageAlert[1]);
        page.setObject("isExpired", false);
        page.setObject("token", token);
        page.render();

        page.removeObject("message");
        page.removeObject("alertType");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String token = req.getParameter("token");

        if(!password.equals(passwordConfirm)) {
            SessionAlert.setMessage(req.getSession(), "Nhập lại mật khẩu chưa khớp", "warning");
            resp.sendRedirect(req.getRequestURI() + "?token=" + token);
            return;
        }

        ForgotPassword forgotPassword = forgotPasswordService.findByToken(token);
        User user = userSerivce.findById(forgotPassword.getUserId());
        user.setPassword(Decrypt.sha256(password));
        user = userSerivce.update(user);
        if(user != null) {
            forgotPasswordService.deleteByToken(token);
            SessionAlert.setMessage(req.getSession(), "Đặt lại mật khẩu thành công", "success");
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            SessionAlert.setMessage(req.getSession(), "Đặt lại mật khẩu thất bại", "danger");
            resp.sendRedirect(req.getRequestURI() + "?token=" + token);
        }
    }

    private boolean isExpired(Timestamp expires) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        return currentTimestamp.after(expires);
    }
}

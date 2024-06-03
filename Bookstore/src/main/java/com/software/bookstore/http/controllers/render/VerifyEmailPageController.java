package com.software.bookstore.http.controllers.render;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.models.VerifyEmail;
import com.software.bookstore.http.services.VerifyEmailService;
import com.software.bookstore.utils.Mails;
import com.software.bookstore.utils.SessionAlert;
import com.software.bookstore.utils.Strings;

@WebServlet("/email/verify")
public class VerifyEmailPageController extends HttpServlet {

    private final VerifyEmailService verifyEmailService = new VerifyEmailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser == null) {
            resp.sendRedirect("/login");
            return;
        }
        
        VerifyEmail verifyEmail = verifyEmailService.findByUserId(loginUser.getId());

        if(verifyEmail == null) {
            resp.sendRedirect("/home");
            return;
        }

        APage page = new ClientPage(req, resp, "verify.jsp", "blank.jsp");
        String[] messageAlert = SessionAlert.getMessage(session);
        page.setTitle("Xác thực email");
        page.setObject("email", loginUser.getEmail());
        page.setObject("message", messageAlert[0]);
        page.setObject("alertType", messageAlert[1]);
        page.render();
        page.removeObject("message");
        page.removeObject("alertType");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        boolean isDelete = verifyEmailService.deleteByUserId(loginUser.getId());
        if(isDelete) {
            VerifyEmail verifyEmail = new VerifyEmail();
            verifyEmail.setEmail(loginUser.getEmail());
            verifyEmail.setUserId(loginUser.getId());
            verifyEmail.setToken(Strings.getUserToken(loginUser));
            verifyEmail.setExpires(new Timestamp(System.currentTimeMillis() + 3 * 60 * 1000));
            verifyEmail = verifyEmailService.save(verifyEmail);
            if(verifyEmail != null) {
                Mails.sendEmailVerification(loginUser.getEmail(), verifyEmail.getToken());
                SessionAlert.setMessage(session, "Chúng tôi đã gửi xác thực đến email của bạn, vui lòng kiểm tra email", "is-success");
                resp.sendRedirect("/email/verify");
            } else {
                SessionAlert.setMessage(session, "Đã có lỗi xảy ra, vui lòng thử lại", "is-danger");
                resp.sendRedirect("/email/verify");
            }
        } else {
            SessionAlert.setMessage(session, "Đã có lỗi xảy ra, vui lòng thử lại", "is-danger");
            resp.sendRedirect("/email/verify");
        }
    }
}

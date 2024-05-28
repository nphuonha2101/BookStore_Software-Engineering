package com.software.bookstore.http.controllers.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.UserSerivce;
import com.software.bookstore.utils.Dates;
import com.software.bookstore.utils.Decrypt;

@WebServlet("/auth/register")
public class RegisterController extends HttpServlet {

    private final UserSerivce userSerivce = new UserSerivce();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        String passwordConfirmation = req.getParameter("passwordConfirmation");
        HttpSession session = req.getSession();

        if(password.equals(passwordConfirmation)) {
            String hashedPassword = Decrypt.sha256(password);
            User user = new User();
            user.setEmail(email);
            user.setPassword(hashedPassword);
            user.setFullName(fullname);
            user.setAddress(address);
            user.setDob(Dates.toSQLTimestamp(birthday));
            if(userSerivce.save(user) != null) {
                session.setAttribute("loginMessage", "Đăng ký tài khoản thành công, vui lòng đăng nhập");
                resp.sendRedirect("/login");
            }
        } else {
            session.setAttribute("registerMessage", "Nhập lại password không chính xác");
            resp.sendRedirect("/register");
        }
    }
}

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
import com.software.bookstore.utils.Decrypt;

@WebServlet("/auth/login")
public class LoginController extends HttpServlet {
    private final UserSerivce userSerivce =  new UserSerivce();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = userSerivce.findByEmail(email);
        
        if(user == null) {
            loginFailed(session, req, resp);
            return;
        }

        if(Decrypt.compare(password, user.getPassword())) {
            session.setAttribute("loginUser", user);
            String back = req.getHeader("referer");
            resp.sendRedirect(back);
        } else
            loginFailed(session, req, resp);
    }

    private void loginFailed(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        session.setAttribute("loginMessage", "Sai tên đăng nhập hoặc mật khẩu");
        resp.sendRedirect("/login");
    }
}

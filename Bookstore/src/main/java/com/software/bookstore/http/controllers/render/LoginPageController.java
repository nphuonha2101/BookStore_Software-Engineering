package com.software.bookstore.http.controllers.render;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;

@WebServlet("/login")
public class LoginPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        APage page = new ClientPage(req, resp, "login.jsp", "blank.jsp");
        if(session.getAttribute("loginMessage") != null)
            page.setObject("loginMessage", session.getAttribute("loginMessage"));
        page.setTitle("Đăng nhập");
        page.render();

        session.removeAttribute("loginMessage");
        page.removeObject("loginMessage");
    }
}

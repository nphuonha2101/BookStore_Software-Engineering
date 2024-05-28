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
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/login")
public class LoginPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        APage page = new ClientPage(req, resp, "login.jsp", "blank.jsp");
        String[] messageAlert = SessionAlert.getMessage(session);
        page.setTitle("Đăng nhập");
        page.setObject("message", messageAlert[0]);
        page.setObject("alertType", messageAlert[1]);
        page.render();

        page.removeObject("message");
        page.removeObject("alertType");
    }
}

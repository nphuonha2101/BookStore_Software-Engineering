package com.software.bookstore.http.controllers.render;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.utils.SessionAlert;

@WebServlet("/forgot-password")
public class ForgotPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        APage page = new ClientPage(req, resp, "forgot.jsp", "blank.jsp");
        page.setTitle("Quên mật khẩu");
        String[] messageAlert = SessionAlert.getMessage(req.getSession());
        page.setObject("message", messageAlert[0]);
        page.setObject("alertType", messageAlert[1]);
        page.render();
        page.removeObject("message");
        page.removeObject("alertType");
    }
}

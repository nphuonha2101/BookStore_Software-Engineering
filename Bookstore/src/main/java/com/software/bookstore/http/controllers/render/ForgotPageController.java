package com.software.bookstore.http.controllers.render;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;

@WebServlet("/forgot-password")
public class ForgotPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        APage page = new ClientPage(req, resp, "forgot.jsp", "blank.jsp");
        page.setTitle("Quên mật khẩu");
        page.render();
    }
}
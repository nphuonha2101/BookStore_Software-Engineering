package com.software.bookstore.http.controllers.render;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.services.BookService;
import com.software.bookstore.mail.Mail;
import com.software.bookstore.utils.Files;
import com.software.bookstore.vnpay.VNPay;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        APage page = new ClientPage(req, resp, "home.jsp", "master.jsp");
        page.setTitle("Trang chủ");
        page.setObject("selectedBooks", bookService.findAllWithOffsetAndLimit(0, 4));
        page.setObject("mustBuyBooks", bookService.findAllWithOffsetAndLimit(4, 4));
        page.render();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerEmail = req.getParameter("customerEmail");
        String content = req.getParameter("content");
        String back = req.getHeader("referer");
        String toMail = Files.env("mail.appName");
        Mail.sendTo(toMail, "You have a new email from " + customerEmail, content, "text/html");
        resp.setHeader("sendMailStatus", "success");
        resp.sendRedirect(back);
    }
}

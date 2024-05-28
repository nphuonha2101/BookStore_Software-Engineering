package com.software.bookstore.http.controllers.render;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.services.BookService;
import com.software.bookstore.utils.SessionAlert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/*")
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = getIdFromReq(req);

        BookService bookService = new BookService();
        List<Book> top20Books = bookService.getRandomBooks(20);
        Book currentBook = bookService.findById(id);

        APage productsPage = new ClientPage(req, resp, "product-detail.jsp", "master.jsp");

        String[] messageAlert = SessionAlert.getMessage(req.getSession());
        
        productsPage.setTitle(currentBook.getTitle());
        productsPage.setObject("book", currentBook);
        productsPage.setObject("books", top20Books);
        productsPage.setObject("message", messageAlert[0]);
        productsPage.setObject("alertType", messageAlert[1]);
        productsPage.render();

        productsPage.removeObject("message");
        productsPage.removeObject("alertType");

    }

    private int getIdFromReq(HttpServletRequest req) {
        String reqUri = req.getRequestURI();
        int lastIndexOfBackSlash = reqUri.lastIndexOf("/");
        String idString = reqUri.substring(lastIndexOfBackSlash + 1);
        return Integer.parseInt(idString);
    }
}

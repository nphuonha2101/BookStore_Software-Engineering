package com.software.bookstore.http.controllers.render;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.services.BookService;
import com.software.bookstore.utils.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product-detail")
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            throw new RuntimeException("Id must not be null");
        }

        int id = Integer.parseInt(req.getParameter("id"));

        BookService bookService = new BookService();
        List<Book> top20Books = bookService.getRandomBooks(20);
        Book currentBook = bookService.findById(id);

        APage productsPage = new ClientPage(req, resp, "product-detail.jsp", "master.jsp");
        productsPage.setTitle(currentBook.getTitle());
        productsPage.setObject("book", currentBook);
        productsPage.setObject("books", top20Books);
        productsPage.render();

    }
}

package com.software.bookstore.http.controllers.render;

import com.software.bookstore.utils.Pagination;
import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.ClientPage;
import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class ProductsController extends HttpServlet {
    private final BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        APage productsPage = new ClientPage(req, resp, "products.jsp", "master.jsp");

        productsPage.setTitle("Danh sách sản phẩm");
        Pagination<Book> pagination = new Pagination<>(bookService, 8, req);
        productsPage.setObject("products", pagination.getPaginatedList());
        productsPage.render();



    }
}

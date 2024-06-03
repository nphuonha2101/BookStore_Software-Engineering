package com.software.bookstore.http.controllers.api;

import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.response.JsonFactory;
import com.software.bookstore.http.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/search")
public class SearchAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q");
        BookService bookService = new BookService();

        List<Book> data = bookService.search(query);
        String responseJson = new JsonFactory.Success(data).build();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(responseJson);

    }
}

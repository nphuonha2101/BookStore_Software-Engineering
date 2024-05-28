package com.software.bookstore.http.controllers.render;

import com.software.bookstore.core.base.page.APage;
import com.software.bookstore.core.base.page.AdminPage;
import com.software.bookstore.http.services.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/books")
public class BookManagementController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();

        APage bookManagementPage = new AdminPage(req, resp, "book-management.jsp", "master.jsp");
        bookManagementPage.setTitle("Quản lý sách");
        bookManagementPage.setObject("categories", categoryService.findAll());
        bookManagementPage.render();
    }
}
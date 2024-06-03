package com.software.bookstore.http.controllers.render;

import com.software.bookstore.http.models.Category;
import com.software.bookstore.http.services.CategoryService;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/products")
public class ProductsController extends HttpServlet {
    private final BookService bookService = new BookService();
    private final CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q");
        List<Category> allCategories = categoryService.findAll();

        APage productsPage = new ClientPage(req, resp, "products.jsp", "master.jsp");

        Map<String, Object> filters = new HashMap<>();

        // if query is not null, add it to filters
        // query by title
        if (query != null) {
            productsPage.setTitle("Kết quả tìm kiếm");
            filters.put("title", query);
        }

        // if category is not null, add it to filters
        String category = req.getParameter("category");
        // case select all categories
        if (category != null) {
            if (category.equals("0")) {
                category = "";
            }
            filters.put("id_category", category);
        }

        // if there is a session, get the filters from the session
        // using filters from session to keep the filters when paginating
        HttpSession session = req.getSession();
        if (session.getAttribute("productsFilters") != null) {
            filters = (Map<String, Object>) session.getAttribute("productsFilters");
            filters.put("id_category", category);
            filters.put("title", query);
        }

        // remove filters with empty values
        filters.values().removeIf(value -> value == null || value.toString().isEmpty());


        System.out.println(filters);
        session.setAttribute("productsFilters", filters);

        productsPage.setTitle("Danh sách sản phẩm");
        Pagination<Book> pagination = new Pagination<>(bookService, 8, req);
        System.out.println(pagination.getPaginatedListWithFilters(filters));
        productsPage.setObject("products", pagination.getPaginatedListWithFilters(filters));
        productsPage.setObject("categories", allCategories);
        productsPage.render();
    }
}

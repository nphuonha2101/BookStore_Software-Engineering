package com.software.bookstore.http.controllers.api.dataTable;

import com.google.gson.Gson;
import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.models.Category;
import com.software.bookstore.http.response.JsonFactory;
import com.software.bookstore.http.services.BookService;
import com.software.bookstore.http.services.CategoryService;
import com.software.bookstore.utils.FormData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MultipartConfig
@WebServlet("/api/dataTable/books")
public class BookDataTableAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int draw = Integer.parseInt(req.getParameter("draw"));
        int start = Integer.parseInt(req.getParameter("start"));
        int length = Integer.parseInt(req.getParameter("length"));
        String searchValue = req.getParameter("search[value]");
        String[] searchColumns = {"title", "author", "publisher", "price"};
        int orderColumn = Integer.parseInt(req.getParameter("order[0][column]"));
        String orderDir = req.getParameter("order[0][dir]");
        String[] columns = {"id", "title", "author", "publisher", "price"};

        BookService bookService = new BookService();
        List<Book> books = bookService.getDataForDataTable(start, length, searchColumns, searchValue, columns[orderColumn], orderDir);

        int totalRecords = (int) bookService.count();
        int filteredRecords = (searchValue != null && !searchValue.isEmpty()) ? books.size() : totalRecords;

        Map<String, Object> responseObj = new HashMap<>();
        responseObj.put("draw", draw);
        responseObj.put("recordsTotal", totalRecords);
        responseObj.put("recordsFiltered", filteredRecords);
        responseObj.put("data", books);

        String responseJson = new Gson().toJson(responseObj);
        resp.setContentType("application/json");
        resp.getWriter().print(responseJson);
        System.out.println(responseJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormData formData = new FormData(req);
        Map<String, String> bookData = formData.getFormFields(List.of("title", "author", "publisher", "categories", "img", "isbn", "price", "summary"));

        Book book = getBookFromFormData(bookData);

        BookService bookService = new BookService();
        String responseJson;
        if (bookService.save(book) != null)
            responseJson = new JsonFactory.Success("Thêm sách thành công").build();
        else
            responseJson = new JsonFactory.InternalServerError("Thêm sách thất bại").build();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(responseJson);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("PATCH")) {
            doPatch(req, resp);
        } else {
            super.service(req, resp);
        }
    }


    private void doPatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> patchFields = List.of("id", "title", "author", "publisher", "categories", "img", "isbn", "price", "summary");
        FormData formData = new FormData(req);
        Map<String, String> bookData = formData.getFormFields(patchFields);

        int id = Integer.parseInt(bookData.get("id"));
        BookService bookService = new BookService();
        Book book = bookService.findById(id);

        Book updatedBook = getBookFromFormData(bookData);
        System.out.println(updatedBook);

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPublisher(updatedBook.getPublisher());
        book.setCategories(updatedBook.getCategories());
        book.setImg(updatedBook.getImg());
        book.setIsbn(updatedBook.getIsbn());
        book.setPrice(updatedBook.getPrice());
        book.setSummary(updatedBook.getSummary());

        String responseJson;
        if (bookService.update(book) != null)
            responseJson = new JsonFactory.Success("Cập nhật thành công").build();
        else
            responseJson = new JsonFactory.InternalServerError("Cập nhật thất bại").build();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(responseJson);
    }

    private Book getBookFromFormData(Map<String, String> bookData) {
        String title = bookData.get("title");
        String author = bookData.get("author");
        String publisher = bookData.get("publisher");
        String categories = bookData.get("categories");
        String img = bookData.get("img");
        String isbn = bookData.get("isbn");
        double price = Double.parseDouble(bookData.get("price"));
        String summary = bookData.get("summary");

        System.out.println("categories: " + categories);

        List<Category> categoryList = new ArrayList<>();

        CategoryService categoryService = new CategoryService();
        for (String category : categories.split(",")) {
            int categoryId = Integer.parseInt(category);
            Category categoryObj = categoryService.findById(categoryId);
            if (categoryObj != null) {
                categoryList.add(categoryObj);
            }
        }

        System.out.println("Category list: " + categoryList);

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(categoryList);
        book.setImg(img);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setSummary(summary);

        return book;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        BookService bookService = new BookService();
        String responseJson;
        if (bookService.delete(id))
            responseJson = new JsonFactory.Success("Xóa sách thành công").build();
        else
            responseJson = new JsonFactory.InternalServerError("Xóa sách thất bại").build();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(responseJson);
    }
}
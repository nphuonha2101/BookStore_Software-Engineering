package com.software.bookstore.http.repositories;

import com.software.bookstore.core.base.context.AppContext;
import com.software.bookstore.http.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BookRepository extends BaseRepository<Book> {
    public BookRepository(String table) {
        super(table);
    }

    @Override
    public boolean delete(int bookId) {
        CategoryRepository categoryRepository = new CategoryRepository("categories");
        if (!categoryRepository.delete(bookId)) return false;

        return super.delete(bookId);
    }

    @Override
    protected Book mapResultSetToModel(ResultSet rs) throws SQLException {
        CategoryRepository categoryRepository = new CategoryRepository("categories");
        return new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("publisher"),
                rs.getString("summary"),
                rs.getString("img"),
                rs.getDouble("price"),
                rs.getString("isbn"),
                categoryRepository.findAll(rs.getInt("id"))
        );
    }

    @Override
    protected Map<String, Object> mapModelToParams(Book model) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", model.getId());
        params.put("title", model.getTitle());
        params.put("author", model.getAuthor());
        params.put("publisher", model.getPublisher());
        params.put("summary", model.getSummary());
        params.put("img", model.getImg());
        params.put("price", model.getPrice());
        params.put("isbn", model.getIsbn());
        return params;

    }
}

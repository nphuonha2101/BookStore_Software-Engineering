package com.software.bookstore.http.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.software.bookstore.core.base.context.AppContext;
import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.models.Category;

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
    public Book save(Book model) {
        CategoryRepository categoryRepository = new CategoryRepository("categories");
        boolean saveBookState = super.save(model) != null;

        if (saveBookState) {
            categoryRepository.save(model);
            return model;
        }
        return null;
    }

    @Override
    public Book update(Book model) {
        CategoryRepository categoryRepository = new CategoryRepository("categories");
        boolean saveBookState = super.update(model) != null;

        if (saveBookState) {
            categoryRepository.update(model);
            return model;
        }
        return null;
    }

    public List<Book> findAllWithFilters(Map<String, Object> filters) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Book> models = null;
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM " + table + " INNER JOIN book_categories " +
                    "ON books.id = book_categories.id_book" + " WHERE 1=1 ");
            for(String key : filters.keySet()) {
                if (filters.get(key) != null) {
                    if (filters.get(key) instanceof String) {
                        query.append("AND ").append(key).append(" LIKE ? ");
                    } else {
                        query.append("AND ").append(key).append(" = ? ");
                    }
                }
            }
            stmt = connection.prepareStatement(query.toString());
            int i = 1;
            for(String key : filters.keySet()) {
                if (filters.get(key) != null) {
                    if (filters.get(key) != null) {
                        if (filters.get(key) instanceof String) {
                            stmt.setString(i++, "%" + filters.get(key) + "%");
                        } else {
                            stmt.setObject(i++, filters.get(key));
                        }
                    }
                }
            }
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            models = new ArrayList<>();
            while(rs.next())
                models.add(mapResultSetToModel(rs));
            return models;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null)
                    rs.close();
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return models;
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

package com.software.bookstore.http.repositories;

import com.software.bookstore.core.base.context.AppContext;
import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepository extends BaseRepository<Category> {

    public CategoryRepository(String tableName) {
        super(tableName);
    }

    public List<Category> findAll(int bookId) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Category> models = null;
        try {
            String query = "SELECT * FROM " + this.table + " WHERE id IN (SELECT id_category FROM book_categories WHERE id_book = ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, bookId);
            rs = stmt.executeQuery();
            models = new ArrayList<>();
            while (rs.next())
                models.add(mapResultSetToModel(rs));
            return models;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public boolean delete(int bookId) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM book_categories WHERE id_book = ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, bookId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public List<Category> save(Book book)  {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        List<Category> categoryList = book.getCategories();

        try {
            for (Category category : categoryList) {
                String query = "INSERT INTO book_categories(id_book, id_category) VALUES(?, ?)";
                stmt = connection.prepareStatement(query);

                stmt.setInt(1, book.getId());
                stmt.setInt(2, category.getId());

                stmt.executeUpdate();
            }
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public List<Category> update(Book book) {
        boolean deleteOldCategory = delete(book.getId());
        List<Category> result = null;
        if (deleteOldCategory) {
            result = save(book);
        }

        return result;
    }

    @Override
    protected Category mapResultSetToModel(ResultSet rs) throws SQLException {
        return new Category(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description")
        );
    }

    @Override
    protected Map<String, Object> mapModelToParams(Category model) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", model.getId());
        params.put("name", model.getName());
        params.put("description", model.getDescription());
        return params;
    }


}

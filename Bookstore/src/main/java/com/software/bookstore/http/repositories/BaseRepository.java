package com.software.bookstore.http.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.software.bookstore.core.base.context.AppContext;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRepository<T> {

    protected String table;

    public BaseRepository(String table) {
        this.table = table;
    }

    public List<T> findAll() {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> models = null;
        try {
            String query = "SELECT * FROM " + table;
            stmt = connection.prepareStatement(query);
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

    public List<T> findAllWithOffsetAndLimit(int offset, int limit) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> models = null;
        try {
            String query = "SELECT * FROM " + table + " LIMIT ? OFFSET ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, limit);
            stmt.setInt(2, offset);
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

    public T findById(int id) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        T model = null;
        try {
            String query = "SELECT * FROM " + table + " WHERE id = ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next())
                model = mapResultSetToModel(rs);
            return model;
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
        return model;
    }

    public T findLast() {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        T model = null;
        long count = getCount();
        try {
            String query = "SELECT * FROM " + table + " LIMIT 1 OFFSET ?";
            stmt = connection.prepareStatement(query);
            stmt.setObject(1, count - 1);
            rs = stmt.executeQuery();
            if(rs.next())
                model = mapResultSetToModel(rs);
            return model;
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
        return model;
    }

    public T save(T model) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Map<String, Object> params = mapModelToParams(model);
            String query = "INSERT INTO " + table + " (";
            for(String key : params.keySet())
                query += key + ", ";
            query = query.substring(0, query.length() - 2) + ") VALUES (";
            for(int i = 0; i < params.size(); i++)
                query += "?, ";
            query = query.substring(0, query.length() - 2) + ")";
            stmt = connection.prepareStatement(query);
            int i = 1;
            for(String key : params.keySet())
                stmt.setObject(i++, params.get(key));
            stmt.executeUpdate();
            model = findLast();
            return model;
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
        return model;
    }

    public T update(T model) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            Map<String, Object> params = mapModelToParams(model);
            String query = "UPDATE " + table + " SET ";
            for(String key : params.keySet())
                query += key + " = ?, ";
            query = query.substring(0, query.length() - 2) + " WHERE id = ?";
            stmt = connection.prepareStatement(query);
            int i = 1;
            for(String key : params.keySet())
                stmt.setObject(i++, params.get(key));
            stmt.setObject(i, params.get("id"));
            stmt.executeUpdate();
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return model;
    }

    public boolean delete(int id) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM " + table + " WHERE id = ?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public long getCount() {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        long count = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + table;
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next())
                count = rs.getLong(1);
            return count;
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
        return count;
    }

    public List<T> query(String sql, Object ... params) {
        Connection connection = AppContext.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> models = null;
        try {
            stmt = connection.prepareStatement(sql);
            for(int i = 0; i < params.length; i++)
                stmt.setObject(i + 1, params[i]);
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

    protected abstract T mapResultSetToModel(ResultSet rs) throws SQLException;
    protected abstract Map<String, Object> mapModelToParams(T model);
}

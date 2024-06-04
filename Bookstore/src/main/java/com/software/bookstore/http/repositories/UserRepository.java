package com.software.bookstore.http.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.software.bookstore.http.enums.EAccountRole;
import com.software.bookstore.http.models.User;
import com.software.bookstore.http.services.CartService;

public class UserRepository extends BaseRepository<User> {

    public UserRepository(String table) {
        super(table);
    }

    @Override
    protected User mapResultSetToModel(ResultSet rs) throws SQLException {
        CartService cartService = new CartService();
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("passwd"));
        user.setFullName(rs.getString("full_name"));
        user.setAddress(rs.getString("address"));
        user.setDob(rs.getTimestamp("dob"));
        user.setCart(cartService.findByUserId(user.getId()));
        user.setRole(EAccountRole.valueOf(rs.getString("role")));
        return user;
    }

    @Override
    protected Map<String, Object> mapModelToParams(User model) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", model.getId());
        params.put("email", model.getEmail());
        params.put("passwd", model.getPassword());
        params.put("full_name", model.getFullName());
        params.put("address", model.getAddress());
        params.put("dob", model.getDob());
        params.put("role", model.getRole().toString());
        return params;
    }
    
}

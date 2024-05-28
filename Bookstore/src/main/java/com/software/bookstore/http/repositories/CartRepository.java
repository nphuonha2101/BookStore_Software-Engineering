package com.software.bookstore.http.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.software.bookstore.http.models.Cart;
import com.software.bookstore.http.services.CartService;

public class CartRepository extends BaseRepository<Cart> {

    public CartRepository(String table) {
        super(table);
    }

    @Override
    protected Cart mapResultSetToModel(ResultSet rs) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getInt("id"));
        cart.setUserId(rs.getInt("user_id"));
        return cart;
    }

    @Override
    protected Map<String, Object> mapModelToParams(Cart model) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", model.getId());
        params.put("user_id", model.getUserId());
        return params;
    }

    public Cart findByUserId(int userId) {
        CartService cartService = new CartService();
        List<Cart> models = query("SELECT * FROM " + getTable() + " WHERE user_id = ?", userId);
        if(models == null || models.isEmpty()) {
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart = cartService.save(cart);

            System.out.println("CART: " + cart.getId() + " USER: " + cart.getUserId());
            return cart;
        } else {
            return models.get(0);
        }
    }
    
}

package com.software.bookstore.http.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.software.bookstore.http.models.CartDetail;
import com.software.bookstore.http.services.BookService;
import com.software.bookstore.http.services.CartService;

public class CartDetailRepository extends BaseRepository<CartDetail>{

    public CartDetailRepository(String table) {
        super(table);
    }

    @Override
    protected CartDetail mapResultSetToModel(ResultSet rs) throws SQLException {
        BookService bookService = new BookService();
        CartService cartService = new CartService();
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCartId(rs.getInt("cart_id"));
        cartDetail.setBookId(rs.getInt("book_id"));
        cartDetail.setQuantity(rs.getInt("quantity"));
        cartDetail.setPrice(rs.getDouble("price"));

        cartDetail.setBook(bookService.findById(cartDetail.getBookId()));
        cartDetail.setCart(cartService.findById(cartDetail.getCartId()));
        return cartDetail;
    }

    @Override
    protected Map<String, Object> mapModelToParams(CartDetail model) {
        Map<String, Object> params = new HashMap<>();
        params.put("cart_id", model.getCartId());
        params.put("book_id", model.getBookId());
        params.put("quantity", model.getQuantity());
        params.put("price", model.getPrice());
        return params;
    }

    public List<CartDetail> findByCartId(int cartId) {
        String sql = "SELECT * FROM " + getTable() + " WHERE cart_id = ?";
        List<CartDetail> models = query(sql, cartId);
        if(models == null || models.isEmpty()) {
            return null;
        }
        return models;
    }

    public boolean deleteByCartIdAndBookId(int cartId, int bookId) {
        String sql = "DELETE FROM " + getTable() + " WHERE cart_id = ? AND book_id = ?";
        return update(sql, cartId, bookId);
    }
    
}

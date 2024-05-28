package com.software.bookstore.http.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.software.bookstore.http.enums.PaymentMethod;
import com.software.bookstore.http.enums.PaymentStatus;
import com.software.bookstore.http.models.Payment;

public class PaymentRepository extends BaseRepository<Payment> {

    public PaymentRepository(String table) {
        super(table);
    }

    @Override
    protected Payment mapResultSetToModel(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getInt("id"));
        payment.setUserId(rs.getInt("user_id"));
        payment.setCartId(rs.getInt("cart_id"));
        payment.setTotal(rs.getDouble("total"));
        payment.setCreatedAt(rs.getTimestamp("created_at"));
        payment.setPaymentMethod(PaymentMethod.valueOf(rs.getString("payment_method")));
        payment.setPaymentStatus(PaymentStatus.valueOf(rs.getString("payment_status")));
        return payment;
    }

    @Override
    protected Map<String, Object> mapModelToParams(Payment model) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", model.getUserId());
        params.put("cart_id", model.getCartId());
        params.put("total", model.getTotal());
        params.put("payment_method", model.getPaymentMethod().name());
        params.put("payment_status", model.getPaymentStatus().name());
        return params;
    }
    
}

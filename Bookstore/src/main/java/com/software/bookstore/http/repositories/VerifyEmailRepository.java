package com.software.bookstore.http.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.software.bookstore.http.models.VerifyEmail;

public class VerifyEmailRepository extends BaseRepository<VerifyEmail> {

    public VerifyEmailRepository(String table) {
        super(table);
    }

    @Override
    protected VerifyEmail mapResultSetToModel(ResultSet rs) throws SQLException {
        VerifyEmail verifyEmail = new VerifyEmail();
        verifyEmail.setId(rs.getInt("id"));
        verifyEmail.setEmail(rs.getString("email"));
        verifyEmail.setToken(rs.getString("token"));
        verifyEmail.setExpires(rs.getTimestamp("expires"));
        verifyEmail.setUserId(rs.getInt("user_id"));
        return verifyEmail;
    }

    @Override
    protected Map<String, Object> mapModelToParams(VerifyEmail model) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", model.getEmail());
        params.put("token", model.getToken());
        params.put("expires", model.getExpires());
        params.put("user_id", model.getUserId());
        return params;
    }
    
}

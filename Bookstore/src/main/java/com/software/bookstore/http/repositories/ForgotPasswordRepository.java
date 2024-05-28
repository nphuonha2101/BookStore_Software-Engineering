package com.software.bookstore.http.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.software.bookstore.http.models.ForgotPassword;

public class ForgotPasswordRepository extends BaseRepository<ForgotPassword> {

    public ForgotPasswordRepository(String table) {
        super(table);
    }

    @Override
    protected ForgotPassword mapResultSetToModel(ResultSet rs) throws SQLException {
        ForgotPassword forgotPassword = new ForgotPassword();
        forgotPassword.setId(rs.getInt("id"));
        forgotPassword.setUserId(rs.getInt("user_id"));
        forgotPassword.setToken(rs.getString("token"));
        forgotPassword.setExpires(rs.getTimestamp("expires"));
        return forgotPassword;
    }

    @Override
    protected Map<String, Object> mapModelToParams(ForgotPassword model) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", model.getUserId());
        params.put("token", model.getToken());
        params.put("expires", model.getExpires());
        return params;
    }
    
}

package com.software.bookstore.http.services;

import java.util.List;

import com.software.bookstore.http.models.ForgotPassword;
import com.software.bookstore.http.repositories.ForgotPasswordRepository;

public class ForgotPasswordService implements IService<ForgotPassword> {

    private final ForgotPasswordRepository repository = new ForgotPasswordRepository("forgot_passwords");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<ForgotPassword> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<ForgotPassword> findAll() {
        return repository.findAll();
    }

    @Override
    public ForgotPassword findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ForgotPassword save(ForgotPassword model) {
        return repository.save(model);
    }

    @Override
    public ForgotPassword update(ForgotPassword model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public ForgotPassword findLast() {
        return repository.findLast();
    }

    public ForgotPassword findByUserId(int userId) {
        String sql = "SELECT * FROM " + repository.getTable() + " WHERE user_id = ?";
        List<ForgotPassword> models = repository.query(sql, userId);
        return models == null || models.isEmpty() ? null : models.get(0);
    }

    public boolean deleteByUserId(int id) {
        String sql = "DELETE FROM " + repository.getTable() + " WHERE user_id = ?";
        return repository.update(sql, id);
    }

    public ForgotPassword findByToken(String token) {
        String sql = "SELECT * FROM " + repository.getTable() + " WHERE token = ?";
        List<ForgotPassword> models = repository.query(sql, token);
        return models == null || models.isEmpty() ? null : models.get(0);
    }

    public boolean deleteByToken(String token) {
        String sql = "DELETE FROM " + repository.getTable() + " WHERE token = ?";
        return repository.update(sql, token);
    }
    
}

package com.software.bookstore.http.services;

import java.util.List;
import java.util.Map;

import com.software.bookstore.http.models.VerifyEmail;
import com.software.bookstore.http.repositories.VerifyEmailRepository;

public class VerifyEmailService implements IService<VerifyEmail> {

    private final VerifyEmailRepository repository = new VerifyEmailRepository("verify_emails");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<VerifyEmail> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<VerifyEmail> findAllWithFilters(Map<String, Object> filters) {
        return repository.findAllWithFilters(filters);
    }

    @Override
    public List<VerifyEmail> findAll() {
        return repository.findAll();
    }

    @Override
    public VerifyEmail findById(int id) {
        return repository.findById(id);
    }

    @Override
    public VerifyEmail save(VerifyEmail model) {
        return repository.save(model);
    }

    @Override
    public VerifyEmail update(VerifyEmail model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public VerifyEmail findLast() {
        return repository.findLast();
    }

    public VerifyEmail findByToken(String token) {
        List<VerifyEmail> models = repository.query("SELECT * FROM " + repository.getTable() + " WHERE token = ?", token);
        return models == null || models.isEmpty() ? null : models.get(0);
    }

    public VerifyEmail findByUserId(int userId) {
        List<VerifyEmail> models = repository.query("SELECT * FROM " + repository.getTable() + " WHERE user_id = ?", userId);
        return models == null || models.isEmpty() ? null : models.get(0);
    }

    public boolean deleteByUserId(int userId) {
        return repository.update("DELETE FROM " + repository.getTable() + " WHERE user_id = ?", userId);
    }
    
}

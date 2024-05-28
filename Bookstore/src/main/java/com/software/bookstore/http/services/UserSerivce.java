package com.software.bookstore.http.services;

import java.util.List;

import com.software.bookstore.http.models.User;
import com.software.bookstore.http.repositories.UserRepository;

public class UserSerivce implements IService<User> {

    private final UserRepository repository = new UserRepository("users");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<User> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public User save(User model) {
        return repository.save(model);
    }

    @Override
    public User update(User model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    public User findByEmail(String email) {
        List<User> users = repository.query("SELECT * FROM " + repository.getTable() + " WHERE EMAIL = ?", email);
        if(users == null || users.isEmpty())
            return null;
        return users.get(0);
    }

    @Override
    public User findLast() {
        return repository.findLast();
    }
    
}

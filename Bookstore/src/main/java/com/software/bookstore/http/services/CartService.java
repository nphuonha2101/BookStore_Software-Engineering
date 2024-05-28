package com.software.bookstore.http.services;

import java.util.List;

import com.software.bookstore.http.models.Cart;
import com.software.bookstore.http.repositories.CartRepository;

public class CartService implements IService<Cart> {

    private final CartRepository repository = new CartRepository("carts");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<Cart> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<Cart> findAll() {
        return repository.findAll();
    }

    @Override
    public Cart findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Cart save(Cart model) {
        return repository.save(model);
    }

    @Override
    public Cart update(Cart model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    public Cart findByUserId(int userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Cart findLast() {
        return repository.findLast();
    }
    
}

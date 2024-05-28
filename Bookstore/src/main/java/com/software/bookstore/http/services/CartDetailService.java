package com.software.bookstore.http.services;

import java.util.List;

import com.software.bookstore.http.models.CartDetail;
import com.software.bookstore.http.repositories.CartDetailRepository;

public class CartDetailService implements IService<CartDetail> {

    private CartDetailRepository repository = new CartDetailRepository("cart_details");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<CartDetail> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<CartDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public CartDetail findById(int id) {
        return repository.findById(id);
    }

    @Override
    public CartDetail save(CartDetail model) {
        return repository.save(model);
    }

    @Override
    public CartDetail update(CartDetail model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public CartDetail findLast() {
        return repository.findLast();
    }
    
    public List<CartDetail> findByCartId(int cartId) {
        return repository.findByCartId(cartId);
    }

    public boolean deleteByCartIdAndBookId(int cartId, int bookId) {
        return repository.deleteByCartIdAndBookId(cartId, bookId);
    }

    public boolean deleteByCartId(int cartId) {
        return repository.update("DELETE FROM " + repository.getTable() + " WHERE cart_id = ?", cartId);
    }
    
}

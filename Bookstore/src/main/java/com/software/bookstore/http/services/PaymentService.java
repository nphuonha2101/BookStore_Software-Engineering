package com.software.bookstore.http.services;

import java.util.List;

import com.software.bookstore.http.models.Payment;
import com.software.bookstore.http.repositories.PaymentRepository;

public class PaymentService implements IService<Payment> {

    private final PaymentRepository repository = new PaymentRepository("payments");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<Payment> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public Payment findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Payment save(Payment model) {
        return repository.save(model);
    }

    @Override
    public Payment update(Payment model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Payment findLast() {
        return repository.findLast();
    }
    
}

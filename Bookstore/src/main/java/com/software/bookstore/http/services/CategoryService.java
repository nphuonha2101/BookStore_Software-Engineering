package com.software.bookstore.http.services;

import com.software.bookstore.http.models.Category;
import com.software.bookstore.http.repositories.CategoryRepository;

import java.util.List;

public class CategoryService implements IService<Category>{
    private final CategoryRepository repository = new CategoryRepository("categories");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<Category> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Category save(Category model) {
        return repository.save(model);
    }

    @Override
    public Category update(Category model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
}

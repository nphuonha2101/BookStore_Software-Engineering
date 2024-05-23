package com.software.bookstore.http.services;

import java.util.List;

public interface IService<T> {
    public List<T> findAll();
    public T findById(int id);
    public T save(T model);
    public T update(T model);
    public boolean delete(int id);
}

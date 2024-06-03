package com.software.bookstore.http.services;

import java.util.List;
import java.util.Map;

public interface IService<T> {
    public long count();
    public List<T> findAllWithOffsetAndLimit(int offset, int limit);
    public List<T> findAllWithFilters(Map<String, Object> filters);
    public List<T> findAll();
    public T findById(int id);
    public T save(T model);
    public T update(T model);
    public boolean delete(int id);
    public T findLast();

}

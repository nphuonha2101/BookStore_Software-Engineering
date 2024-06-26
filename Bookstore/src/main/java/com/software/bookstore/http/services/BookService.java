package com.software.bookstore.http.services;

import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService implements IService<Book>{
    private final BookRepository repository = new BookRepository("books");

    @Override
    public long count() {
        return repository.getCount();
    }

    @Override
    public List<Book> findAllWithOffsetAndLimit(int offset, int limit) {
        return repository.findAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    public List<Book> findAllWithFilters(Map<String, Object> filters) {
        return repository.findAllWithFilters(filters);
    }

    public List<Book> getDataForDataTable(int start, int length, String[] searchColumns, String searchValue, String orderColumn, String orderDir) {
        return repository.getDataForDataTable(start, length, searchColumns, searchValue, orderColumn, orderDir);
    }


    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Book save(Book model) {
        return repository.save(model);
    }

    @Override
    public Book update(Book model) {
        return repository.update(model);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    public List<Book> getRandomBooks(int quantity) {
        List<Book> result = new ArrayList<>();
        long currentRowInDB = count();
        quantity = quantity > currentRowInDB ? (int) currentRowInDB : quantity;

        for (int i = 0; i < quantity; i++) {
            int randomId = (int) (Math.floor(Math.random() * currentRowInDB));
            result.add(findById(randomId));
        }

        return result;
    }

    @Override
    public Book findLast() {
        return repository.findLast();
    }

    public List<Book> search(String query) {
        return repository.getDataForDataTable(0, 8, new String[]{"title"}, query, "title", "asc");
    }
}

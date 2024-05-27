package com.software.bookstore.http.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    @Test
    void delete() {
        BookRepository bookRepository = new BookRepository("books");
        assertTrue(bookRepository.delete(1));
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.software.bookstore.http.models.Book;
import com.software.bookstore.http.models.Category;
import com.software.bookstore.http.services.BookService;

/**
 *
 * @author thang
 */
public class PaginationTest {
    private BookService service;
    private HttpServletRequest req;
    private Pagination<Book> pagination;
    private int limit;

    @Before
    public void setUp() {
        service = PowerMockito.mock(BookService.class);
        req = PowerMockito.mock(HttpServletRequest.class);
        limit = 3;
        pagination = new Pagination<>(service, limit, req);
    }

    private List<Book> fakeLimitAndOffset(int offset, int limit) {
        List<Book> books = Arrays.asList(
            new Book(1, "Book 1", "Author 1", "Publisher 1", "Summary 1", "image1.jpg", 1000, "123", Arrays.asList(new Category(1, "Category 1", "Description 1"))),
            new Book(2, "Book 2", "Author 2", "Publisher 2", "Summary 2", "image2.jpg", 2000, "456", Arrays.asList(new Category(2, "Category 2", "Description 2"))),
            new Book(3, "Book 3", "Author 3", "Publisher 3", "Summary 3", "image3.jpg", 3000, "789", Arrays.asList(new Category(3, "Category 3", "Description 3"))),
            new Book(4, "Book 4", "Author 4", "Publisher 4", "Summary 4", "image4.jpg", 4000, "101", Arrays.asList(new Category(4, "Category 4", "Description 4"))),
            new Book(5, "Book 5", "Author 5", "Publisher 5", "Summary 5", "image5.jpg", 5000, "112", Arrays.asList(new Category(5, "Category 5", "Description 5")))
        );

        List<Book> result = new ArrayList<>();

        for(int i = offset; i < limit; i++) {
            result.add(books.get(i));
        }
        return result;
    }

    @Test
    public void testGetPaginatedList() {
        String page = "1";
        
        PowerMockito.when(req.getParameter(eq("page"))).thenReturn(page);
        int offset = anyInt();
        List<Book> expected = fakeLimitAndOffset(offset, limit);
        PowerMockito.when(service.findAllWithOffsetAndLimit(offset, eq(limit))).thenReturn(expected);
        List<Book> actual = pagination.getPaginatedList();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPaginatedListWithFilters() throws Exception {
        PowerMockito.doNothing().when(req, "setAttribute", eq("totalPages"), anyInt());
        Map<String, Object> filters = new HashMap<>();

        filters.put("title", "Book 1");
        filters.put("author", "Author 1");
        filters.put("category", "Category 1");
        List<Book> expected = Arrays.asList(
            new Book(1, "Book 1", "Author 1", "Publisher 1", "Summary 1", "image1.jpg", 1000, "123", Arrays.asList(new Category(1, "Category 1", "Description 1")))
        );

        PowerMockito.when(service.findAllWithFilters(filters)).thenReturn(expected);
        List<Book> actual = pagination.getPaginatedListWithFilters(filters);

        assertEquals(expected, actual);
    }

    @Test
    public void testSetLimit() {
        pagination.setLimit(3);
        PowerMockito.when(service.count()).thenReturn(15L);
        long count = service.count();
        int expected = (int) Math.ceil(count / 3);
        int actual = pagination.getTotalPages();
        assertEquals(expected, actual);
    }
    
}

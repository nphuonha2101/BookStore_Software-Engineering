package com.software.bookstore.http.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String summary;
    private String img;
    private double price;
    private String isbn;
    private List<Category> categories;
}

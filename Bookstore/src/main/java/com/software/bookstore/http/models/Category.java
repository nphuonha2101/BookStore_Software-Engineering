package com.software.bookstore.http.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private int id;
    private String name;
    private String description;
}

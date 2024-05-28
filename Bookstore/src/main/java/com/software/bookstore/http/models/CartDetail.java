package com.software.bookstore.http.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDetail {
    private int cartId;
    private int bookId;
    private int quantity;
    private double price;

    private Book book;
    private Cart cart;
}

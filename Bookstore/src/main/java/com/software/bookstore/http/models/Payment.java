package com.software.bookstore.http.models;

import java.sql.Timestamp;

import com.software.bookstore.http.enums.PaymentMethod;
import com.software.bookstore.http.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    private int id;
    private int userId;
    private int cartId;
    private double total;
    private Timestamp createdAt;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
}

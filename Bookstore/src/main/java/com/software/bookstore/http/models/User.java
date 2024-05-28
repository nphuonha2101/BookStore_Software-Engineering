package com.software.bookstore.http.models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private Timestamp dob;
    private Cart cart;
}

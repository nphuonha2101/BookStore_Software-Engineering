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
public class ForgotPassword {
    private int id;
    private int userId;
    private String token;
    private Timestamp expires;
}

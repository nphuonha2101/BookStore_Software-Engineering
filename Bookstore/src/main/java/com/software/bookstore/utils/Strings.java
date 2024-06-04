package com.software.bookstore.utils;

import com.google.gson.Gson;
import com.software.bookstore.http.models.User;

public class Strings {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static String getUserToken(User user) {
        return Decrypt.sha256(user.getEmail() + user.getPassword() + System.currentTimeMillis() + "" + Files.env("hash.secret"));
    }
}

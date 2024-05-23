package com.software.bookstore.utils;

import com.google.gson.Gson;

public class Strings {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}

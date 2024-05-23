package com.software.bookstore.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppPropertiesTest {

    @Test
    void getProperty() {
        AppProperties appProperties = AppProperties.getInstance();
        String value = appProperties.getProperty("mail.appName");
        assertEquals("filmbookingdn@gmail.com", value);
    }
}
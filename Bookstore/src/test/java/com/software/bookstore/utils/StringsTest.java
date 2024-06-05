/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.gson.Gson;
import com.software.bookstore.http.models.Cart;
import com.software.bookstore.http.models.User;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

import java.sql.Timestamp;

/**
 *
 * @author thang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Decrypt.class, Files.class})
public class StringsTest {
    
    @Before
    public void setUp() {
        PowerMockito.mockStatic(Decrypt.class);
        PowerMockito.mockStatic(Files.class);
    }

    @Test
    public void testToJson() {
        User user = new User(1, "user@gmail.com", "123", "User", "Address", new Timestamp(System.currentTimeMillis()), new Cart());
        String expected = new Gson().toJson(user);
        String actual = Strings.toJson(user);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetUserToken() {
        User user = new User(1, "user@gmail.com", "123", "User", "Address", new Timestamp(System.currentTimeMillis()), new Cart());
        String expected = "123";
        PowerMockito.when(Decrypt.sha256(anyString())).thenReturn(expected);
        PowerMockito.when(Files.env("app.secret")).thenReturn(anyString());
        String actual = Strings.getUserToken(user);
        assertEquals(expected, actual);
    }
    
}

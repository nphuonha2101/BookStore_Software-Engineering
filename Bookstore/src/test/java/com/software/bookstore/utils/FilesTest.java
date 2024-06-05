/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 *
 * @author thang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Files.class})
public class FilesTest {
    
    @Before
    public void setUp() {
        PowerMockito.mockStatic(Files.class);
    }

    @Test
    public void testEnv() {
        String expected = "http://localhost:8080";
        PowerMockito.when(Files.env("app.host")).thenReturn(expected);
        String actual = Files.env("app.host");
        assertEquals(expected, actual);
    }
    
}

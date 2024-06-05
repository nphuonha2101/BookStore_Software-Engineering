/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
/**
 *
 * @author thang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Decrypt.class})
public class DecryptTest {

    @Before
    public void setUp() {
        PowerMockito.mockStatic(Decrypt.class);
    }

    @Test
    public void testSha256() {
        String input = "hashme";
        String expected = "hashed";
        PowerMockito.when(Decrypt.sha256(input)).thenReturn(expected);
        String actual = Decrypt.sha256(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompare() {
        String input = "hashme";
        String hash = "hashed";
        PowerMockito.when(Decrypt.compare(input, hash)).thenReturn(true);
        boolean actual = Decrypt.compare(input, hash);
        assertEquals(true, actual);
    }

    @Test
    public void testHmacSha512() {
        String input = "hashme";
        String expected = "hashed";
        String secretKey = "secret";
        PowerMockito.when(Decrypt.hmacSha512(secretKey, input)).thenReturn(expected);
        String actual = Decrypt.hmacSha512(secretKey, input);
        assertEquals(expected, actual);
    }
    
}

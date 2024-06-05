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
    }

    @Test
    public void testHmacSha512() {
    }
    
}

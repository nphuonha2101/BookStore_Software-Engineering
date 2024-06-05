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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;

/**
 *
 * @author thang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FormData.class, HttpServletRequest.class})
public class FormDataTest {

    private FormData formDataSpy;
    private HttpServletRequest request;
    
    @Before
    public void setUp() {
        request = PowerMockito.mock(HttpServletRequest.class);
        formDataSpy = PowerMockito.spy(new FormData(request));
    }

    @Test
    public void testGetFormFields() {
        List<String> fields = Arrays.asList("id", "name", "age");
        List<String> values = Arrays.asList("1", "John Doe", "30");
        Map<String, String> expected = new HashMap<>();
        for (int i = 0; i < fields.size(); i++) {
            expected.put(fields.get(i), values.get(i));
        }
        PowerMockito.when(formDataSpy.getFormFields(fields)).thenReturn(expected);
        Map<String, String> actual = formDataSpy.getFormFields(fields);
        assertEquals(expected, actual);
    }
    
}

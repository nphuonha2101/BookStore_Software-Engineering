/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author thang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpSession.class, SessionAlert.class})
public class SessionAlertTest {
    
    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        session = PowerMockito.mock(HttpSession.class);

        PowerMockito.doNothing().when(session, "setAttribute", anyString(), anyString());
        PowerMockito.doReturn("getted").when(session, "getAttribute", anyString());
        PowerMockito.doNothing().when(session, "removeAttribute", anyString());
    }

    @org.junit.Test
    public void testSetMessage() throws Exception {
        String message = "message";
        SessionAlert.setMessage(session, message, "success");
        verify(session, times(2)).setAttribute(anyString(), anyString());
    }

    @org.junit.Test
    public void testGetMessage() {
        String expected = "getted";
        String[] actual = SessionAlert.getMessage(session);

        verify(session, times(2)).getAttribute(anyString());
        assertEquals(expected, actual[0]);
    }

    @org.junit.Test
    public void testClearMessage() throws Exception {
        SessionAlert.clearMessage(session);
        
        verify(session, times(2)).removeAttribute(anyString());
    }
    
}

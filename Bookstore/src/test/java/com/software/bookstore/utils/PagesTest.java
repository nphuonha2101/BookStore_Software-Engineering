/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import org.junit.Test;

import com.software.bookstore.constants.CPage;

import static org.junit.Assert.*;

/**
 *
 * @author thang
 */
public class PagesTest {
    
    public PagesTest() {
    }

    @Test
    public void testGetClientLayoutDir() {
        String actual = Pages.getClientLayoutDir();
        String expected = CPage.CLIENT_LAYOUT_DIR;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAdminLayoutDir() {
        String actual = Pages.getAdminLayoutDir();
        String expected = CPage.ADMIN_LAYOUT_DIR;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAdminPageDir() {
        String actual = Pages.getAdminPageDir();
        String expected = CPage.ADMIN_PAGE_DIR;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetClientPageDir() {
        String actual = Pages.getClientPageDir();
        String expected = CPage.CLIENT_PAGE_DIR;
        assertEquals(expected, actual);
    }
    
}

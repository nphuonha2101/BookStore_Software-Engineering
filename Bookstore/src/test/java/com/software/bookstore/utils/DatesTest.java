/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Timestamp;

/**
 *
 * @author thang
 */
public class DatesTest {
    
    public DatesTest() {

    }

    @Test
    public void testToSQLTimestamp_3args() {
        Timestamp actual = Dates.toSQLTimestamp(2020, 10, 10);
        Timestamp expected = Timestamp.valueOf("2020-10-10 00:00:00");
        assertEquals(expected, actual);
    }

    @Test
    public void testToSQLTimestamp_String() {
        Timestamp actual = Dates.toSQLTimestamp("2020-10-10");
        Timestamp expected = Timestamp.valueOf("2020-10-10 00:00:00");
        assertEquals(expected, actual);
    }
    
}

package com.software.bookstore.utils;

import java.sql.Timestamp;

public class Dates {
    public static Timestamp toSQLTimestamp(int year, int month, int day) {
        return Timestamp.valueOf(year + "-" + month + "-" + day + " 00:00:00");
    }

    public static Timestamp toSQLTimestamp(String date) {
        return Timestamp.valueOf(date + " 00:00:00");
    }
}

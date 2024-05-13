package com.software.bookstore.utils;

import java.util.Properties;

import com.software.bookstore.core.base.AppContext;

public class Files {
    public static String env(String key) {
        Properties props = AppContext.getInstance().getProps();
        return props.getProperty(key);
    }
}

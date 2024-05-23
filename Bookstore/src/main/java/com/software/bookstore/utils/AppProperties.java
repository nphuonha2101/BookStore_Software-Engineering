package com.software.bookstore.utils;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class AppProperties {
    private Properties properties;
    private static AppProperties instance;

    private AppProperties() {
        properties = getApplicationProperties();
    }

    public static AppProperties getInstance() {
        if (instance == null) {
            instance = new AppProperties();
        }
        return instance;
    }

    /**
     * Load application properties from application.properties file
     *
     * @return Properties object containing application properties
     */
    private static Properties getApplicationProperties() {
        try (InputStream inputStream = AppProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("Cannot load application.properties file");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

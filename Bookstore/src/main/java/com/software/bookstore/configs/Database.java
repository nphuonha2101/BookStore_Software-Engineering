package com.software.bookstore.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.software.bookstore.utils.Files;
public class Database {
    private String url;
    private String username;
    private String password;
    private String driver;

    /**
     * Không cho phép new đối tượng Database từ bên ngoài
     */
    private Database() {
        /**
         * Lấy các giá trị từ bên trong file application.properties
         */
        this.url = Files.env("db.url");
        this.username = Files.env("db.username");
        this.password = Files.env("db.password");
        this.driver = Files.env("db.driver");
    }

    private static Database newInstance() {
        return new Database();
    }

    public static Connection getConnection() {
        Database instance = newInstance();
        Connection connection = null;
        try {
            Class.forName(instance.driver);
            connection = DriverManager.getConnection(instance.url, instance.username, instance.password);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

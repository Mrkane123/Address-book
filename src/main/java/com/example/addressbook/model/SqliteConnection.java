package com.example.addressbook.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
    private static Connection instance = null;

    private SqliteConnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getInstance() {
        if (instance == null) {
            String url = "jdbc:sqlite:contacts.db";
            try {
                instance = DriverManager.getConnection(url);
            } catch (SQLException sqlEx) {
                System.err.println("Failed to create a connection to the database: " + sqlEx.getMessage());
            }
        }
        return instance;
    }
}

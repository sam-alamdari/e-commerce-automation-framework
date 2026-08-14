package com.sam.automation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/ecommerce_test_db";

    private static final String DB_USERNAME =
            "automation_user";

    private DatabaseUtils() {
    }

    public static Connection getConnection() throws SQLException {

        String dbPassword =
                System.getenv("ECOMMERCE_DB_PASSWORD");

        if (dbPassword == null || dbPassword.isBlank()) {
            throw new IllegalStateException(
                    "ECOMMERCE_DB_PASSWORD environment variable must be set"
            );
        }

        return DriverManager.getConnection(
                DB_URL,
                DB_USERNAME,
                dbPassword
        );
    }
}
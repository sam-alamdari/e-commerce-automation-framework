package com.sam.automation.database;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/ecommerce_test_db";

    private static final String DB_USERNAME =
            "automation_user";

    @Test(groups = {"database", "regression"})
    public void verifyDatabaseConnection() {

        String dbPassword =
                System.getenv("ECOMMERCE_DB_PASSWORD");

        Assert.assertNotNull(
                dbPassword,
                "ECOMMERCE_DB_PASSWORD environment variable must be set"
        );

        try (Connection connection =
                     DriverManager.getConnection(
                             DB_URL,
                             DB_USERNAME,
                             dbPassword
                     )) {

            Assert.assertNotNull(
                    connection,
                    "Database connection should not be null"
            );

            Assert.assertFalse(
                    connection.isClosed(),
                    "Database connection should be open"
            );

        } catch (SQLException e) {

            Assert.fail(
                    "Failed to connect to MySQL database: "
                            + e.getMessage()
            );
        }
    }
}

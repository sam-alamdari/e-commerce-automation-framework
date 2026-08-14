package com.sam.automation.database;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDatabaseTest {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/ecommerce_test_db";

    private static final String DB_USERNAME =
            "automation_user";

    @Test(groups = {"database", "regression"})
    public void verifyProductData() {

        String dbPassword =
                System.getenv("ECOMMERCE_DB_PASSWORD");

        Assert.assertNotNull(
                dbPassword,
                "ECOMMERCE_DB_PASSWORD environment variable must be set"
        );

        String query =
                "SELECT name, price, category FROM products WHERE id = ?";

        try (Connection connection =
                     DriverManager.getConnection(
                             DB_URL,
                             DB_USERNAME,
                             dbPassword
                     );

             PreparedStatement statement =
                     connection.prepareStatement(query)) {

            statement.setInt(1, 1);

            try (ResultSet resultSet = statement.executeQuery()) {

                Assert.assertTrue(
                        resultSet.next(),
                        "Product with id 1 should exist in the database"
                );

                String actualName =
                        resultSet.getString("name");

                double actualPrice =
                        resultSet.getDouble("price");

                String actualCategory =
                        resultSet.getString("category");

                Assert.assertEquals(
                        actualName,
                        "Samsung Galaxy S6",
                        "Product name should match"
                );

                Assert.assertEquals(
                        actualPrice,
                        360.00,
                        "Product price should match"
                );

                Assert.assertEquals(
                        actualCategory,
                        "Phones",
                        "Product category should match"
                );
            }

        } catch (SQLException e) {

            Assert.fail(
                    "Database query failed: " + e.getMessage()
            );
        }
    }

    @Test(groups = {"database", "regression"})
    public void verifyProductCount() {

        String dbPassword =
                System.getenv("ECOMMERCE_DB_PASSWORD");

        Assert.assertNotNull(
                dbPassword,
                "ECOMMERCE_DB_PASSWORD environment variable must be set"
        );

        String query =
                "SELECT COUNT(*) AS product_count FROM products";

        try (Connection connection =
                     DriverManager.getConnection(
                             DB_URL,
                             DB_USERNAME,
                             dbPassword
                     );

             PreparedStatement statement =
                     connection.prepareStatement(query);

             ResultSet resultSet =
                     statement.executeQuery()) {

            Assert.assertTrue(
                    resultSet.next(),
                    "Product count result should be available"
            );

            int productCount =
                    resultSet.getInt("product_count");

            Assert.assertEquals(
                    productCount,
                    3,
                    "Product count should be 3"
            );

        } catch (SQLException e) {

            Assert.fail(
                    "Database query failed: " + e.getMessage()
            );
        }
    }
}
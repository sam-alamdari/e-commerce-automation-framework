package com.sam.automation.database;

import com.sam.automation.utils.DatabaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    @Test(groups = {"database", "regression"})
    public void verifyDatabaseConnection() {

        try (Connection connection =
                     DatabaseUtils.getConnection()) {

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

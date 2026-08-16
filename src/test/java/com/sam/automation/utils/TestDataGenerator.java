package com.sam.automation.utils;

public class TestDataGenerator {

    private TestDataGenerator() {
    }

    public static String generateUniqueUsername() {
        return "sam_automation_" + System.currentTimeMillis();
    }

    public static String getTestPassword() {

        String password =
                System.getenv("ECOMMERCE_TEST_PASSWORD");

        if (password == null || password.isBlank()) {
            throw new IllegalStateException(
                    "ECOMMERCE_TEST_PASSWORD environment variable must be set"
            );
        }

        return password;
    }
}

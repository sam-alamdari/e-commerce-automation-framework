package com.sam.automation.data;

public class TestData {

    public static final String TEST_USERNAME =
            "sam_automation_test_2026";

    public static final String TEST_PASSWORD =
            getTestPassword();

    private TestData() {
    }

    private static String getTestPassword() {

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

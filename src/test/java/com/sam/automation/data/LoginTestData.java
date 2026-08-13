package com.sam.automation.data;

import org.testng.annotations.DataProvider;

public class LoginTestData {

    private LoginTestData() {
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        return new Object[][]{
                {
                        TestData.TEST_USERNAME,
                        "wrongPassword1",
                        "Wrong password."
                },
                {
                        TestData.TEST_USERNAME,
                        "wrongPassword2",
                        "Wrong password."
                },
                {
                        TestData.TEST_USERNAME,
                        "wrongPassword3",
                        "Wrong password."
                }
        };
    }
}

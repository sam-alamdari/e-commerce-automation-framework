package com.sam.automation.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass
    public void setupApi() {

        RestAssured.baseURI = "https://dummyjson.com";
    }
}
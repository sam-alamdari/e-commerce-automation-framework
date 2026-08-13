package com.sam.automation.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiSmokeTest {

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Verify product details endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"api", "smoke"})
    public void verifyProductsEndpoint() {

        given()
                .baseUri("https://dummyjson.com")
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("price", notNullValue())
                .body("category", notNullValue());
    }
}

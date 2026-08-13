package com.sam.automation.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

public class ApiSmokeTest extends ApiBaseTest {

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Verify product details endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"api", "smoke"})
    public void verifyProductDetails() {

        given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("price", notNullValue())
                .body("category", notNullValue());
    }

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Verify products list endpoint")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"api", "regression"})
    public void verifyProductsList() {

        given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0))
                .body("total", greaterThan(0));
    }

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Verify products limit query parameter")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"api", "regression"})
    public void verifyProductsLimit() {

        given()
                .queryParam("limit", 5)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products.size()", equalTo(5))
                .body("limit", equalTo(5));
    }
}
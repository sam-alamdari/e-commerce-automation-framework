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

public class ApiCrudTest {

    private static final String BASE_URI =
            "https://dummyjson.com";

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Create product")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"api", "regression"})
    public void verifyCreateProduct() {

        String requestBody = """
                {
                  "title": "Automation Test Product",
                  "price": 99
                }
                """;

        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/products/add")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body(
                        "title",
                        equalTo("Automation Test Product")
                )
                .body(
                        "price",
                        equalTo(99)
                );
    }

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Update product")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"api", "regression"})
    public void verifyUpdateProduct() {

        String requestBody = """
                {
                  "title": "Updated Automation Product"
                }
                """;

        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body(
                        "title",
                        equalTo("Updated Automation Product")
                );
    }

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Delete product")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"api", "regression"})
    public void verifyDeleteProduct() {

        given()
                .baseUri(BASE_URI)
                .when()
                .delete("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("isDeleted", equalTo(true));
    }
}

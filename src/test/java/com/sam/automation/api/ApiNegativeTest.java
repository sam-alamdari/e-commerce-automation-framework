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

public class ApiNegativeTest extends ApiBaseTest {

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Verify invalid product request")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"api", "regression"})
    public void verifyInvalidProductId() {

        given()
                .when()
                .get("/products/999999")
                .then()
                .statusCode(404)
                .body("message", notNullValue());
    }

    @Epic("E-Commerce")
    @Feature("API Testing")
    @Story("Verify invalid product search")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"api", "regression"})
    public void verifyProductSearchWithNoResults() {

        given()
                .queryParam(
                        "q",
                        "productThatDoesNotExist123456"
                )
                .when()
                .get("/products/search")
                .then()
                .statusCode(200)
                .body("products.size()", equalTo(0))
                .body("total", equalTo(0));
    }
}
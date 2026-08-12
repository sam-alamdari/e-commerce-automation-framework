package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.ProductPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("Product Details")
    @Story("Verify product information")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"smoke", "regression"})
    public void verifyProductInformation() {

        HomePage homePage =
                new HomePage(driver);

        ProductPage productPage =
                homePage.clickSamsungGalaxyS6();

        Assert.assertEquals(
                productPage.getProductTitle(),
                "Samsung galaxy s6",
                "Product title should be Samsung galaxy s6"
        );

        Assert.assertTrue(
                productPage.getProductPrice().contains("$360"),
                "Product price should be $360"
        );

        Assert.assertTrue(
                productPage.getProductDescription()
                        .contains("Samsung Galaxy S6"),
                "Product description should contain Samsung Galaxy S6"
        );
    }
}

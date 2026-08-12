package com.sam.automation.utils;

import com.sam.automation.pages.CartPage;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class ECommerceFlow {

    private final WebDriver driver;

    public ECommerceFlow(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage addSamsungGalaxyS6ToCart() {

        HomePage homePage =
                new HomePage(driver);

        ProductPage productPage =
                homePage.clickSamsungGalaxyS6();

        productPage.clickAddToCart();

        AlertUtils alertUtils =
                new AlertUtils(driver);

        alertUtils.getTextAndAccept();

        return productPage.openCart();
    }
}

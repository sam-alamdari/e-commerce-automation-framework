package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.pages.CartPage;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.ProductPage;
import com.sam.automation.utils.AlertUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("Shopping Cart")
    @Story("Add and remove product from cart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"smoke", "regression"})
    public void verifyAddToCart(){

        HomePage homePage = new HomePage(driver);

        ProductPage productPage =
                homePage.clickSamsungGalaxyS6();

        productPage.clickAddToCart();

        AlertUtils alertUtils =
                new AlertUtils(driver);

        String alertMessage =
                alertUtils.getTextAndAccept();

        Assert.assertEquals(
                alertMessage,
                "Product added",
                "Add to Cart confirmation message is incorrect"
        );

        CartPage cartPage =
                productPage.openCart();

        Assert.assertTrue(
                cartPage.isProductDisplayedInCart(),
                "Samsung galaxy s6 should be displayed in the cart"
        );

        Assert.assertEquals(
                cartPage.getProductPrice(),
                "360",
                "Product price in cart should be 360"
        );

        cartPage.removeProduct();

        Assert.assertTrue(
                cartPage.isProductRemoved(),
                "Product should be removed from the cart"
        );
    }
}

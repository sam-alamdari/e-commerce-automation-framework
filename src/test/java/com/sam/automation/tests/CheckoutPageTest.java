package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.data.TestData;
import com.sam.automation.pages.CartPage;
import com.sam.automation.pages.CheckoutPage;
import com.sam.automation.pages.OrderConfirmationPage;
import com.sam.automation.utils.ECommerceFlow;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("Checkout")
    @Story("Complete purchase")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"smoke", "regression"})
    public void verifyCheckoutForm() {

        ECommerceFlow eCommerceFlow =
                new ECommerceFlow(driver);

        CartPage cartPage =
                eCommerceFlow.addSamsungGalaxyS6ToCart();

        CheckoutPage checkoutPage =
                cartPage.clickPlaceOrder();

        Assert.assertTrue(
                checkoutPage.isCheckoutModalDisplayed(),
                "Checkout modal should be displayed"
        );

        checkoutPage.fillCheckoutForm(
                TestData.CUSTOMER_NAME,
                TestData.CUSTOMER_COUNTRY,
                TestData.CUSTOMER_CITY,
                TestData.CUSTOMER_CARD,
                TestData.CUSTOMER_MONTH,
                TestData.CUSTOMER_YEAR
        );

        OrderConfirmationPage confirmationPage =
                checkoutPage.clickPurchase();

        Assert.assertEquals(
                confirmationPage.getConfirmationTitle(),
                "Thank you for your purchase!",
                "Purchase confirmation title is incorrect"
        );

        Assert.assertTrue(
                confirmationPage.getOrderDetails()
                        .contains("Amount: 360 USD"),
                "Order amount should be 360 USD"
        );

        Assert.assertTrue(
                confirmationPage.getOrderDetails()
                        .contains(
                                "Name: "
                                        + TestData.CUSTOMER_NAME
                        ),
                "Customer name in order confirmation is incorrect"
        );

        confirmationPage.clickOk();
    }
}


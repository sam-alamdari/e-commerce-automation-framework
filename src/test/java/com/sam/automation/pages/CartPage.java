package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By cartTable = By.id("tbodyid");
    private final By productName =
            By.xpath("//tbody[@id='tbodyid']//td[text()='Samsung galaxy s6']");
    private final By productPrice =
            By.xpath("//tbody[@id='tbodyid']//tr[td[text()='Samsung galaxy s6']]//td[3]");
    private final By deleteProductLink =
            By.xpath("//tbody[@id='tbodyid']//tr[td[text()='Samsung galaxy s6']]//a[text()='Delete']");
    private final By placeOrderButton =
            By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isCartDisplayed() {
        return waitUtils.waitForVisibility(cartTable).isDisplayed();
    }

    public boolean isProductDisplayedInCart() {
        return waitUtils.waitForDisplayed(productName);
    }

    public String getProductPrice() {
        return waitUtils.waitForVisibility(productPrice).getText();
    }

    public void removeProduct() {
        waitUtils.waitForClickable(deleteProductLink).click();
    }

    public boolean isProductRemoved() {
        return waitUtils.waitForInvisibility(productName);
    }
    public CheckoutPage clickPlaceOrder() {
        waitUtils.waitForClickable(placeOrderButton).click();

        return new CheckoutPage(driver);
    }
}

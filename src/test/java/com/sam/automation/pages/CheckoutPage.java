package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By checkoutModal = By.id("orderModal");

    private final By nameField = By.id("name");
    private final By countryField = By.id("country");
    private final By cityField = By.id("city");
    private final By creditCardField = By.id("card");
    private final By monthField = By.id("month");
    private final By yearField = By.id("year");

    private final By purchaseButton =
            By.xpath("//button[text()='Purchase']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isCheckoutModalDisplayed() {
        return waitUtils.waitForDisplayed(checkoutModal);
    }

    public void enterName(String name) {
        waitUtils.waitForVisibility(nameField)
                .sendKeys(name);
    }

    public void enterCountry(String country) {
        waitUtils.waitForVisibility(countryField)
                .sendKeys(country);
    }

    public void enterCity(String city) {
        waitUtils.waitForVisibility(cityField)
                .sendKeys(city);
    }

    public void enterCreditCard(String creditCard) {
        waitUtils.waitForVisibility(creditCardField)
                .sendKeys(creditCard);
    }

    public void enterMonth(String month) {
        waitUtils.waitForVisibility(monthField)
                .sendKeys(month);
    }

    public void enterYear(String year) {
        waitUtils.waitForVisibility(yearField)
                .sendKeys(year);
    }
    public void fillCheckoutForm(
            String name,
            String country,
            String city,
            String creditCard,
            String month,
            String year) {

        enterName(name);
        enterCountry(country);
        enterCity(city);
        enterCreditCard(creditCard);
        enterMonth(month);
        enterYear(year);
    }

    public OrderConfirmationPage clickPurchase() {
        waitUtils.waitForClickable(purchaseButton)
                .click();
        return new OrderConfirmationPage(driver);
    }
}

package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By confirmationTitle =
            By.xpath("//h2[text()='Thank you for your purchase!']");

    private final By orderDetails =
            By.cssSelector(".sweet-alert p");

    private final By okButton =
            By.xpath("//button[text()='OK']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getConfirmationTitle() {
        return waitUtils.waitForVisibility(confirmationTitle).getText();
    }

    public String getOrderDetails() {
        return waitUtils.waitForVisibility(orderDetails).getText();
    }

    public void clickOk() {
        waitUtils.waitForClickable(okButton).click();
    }
}

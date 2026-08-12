package com.sam.automation.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AlertUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    public String getTextAndAccept() {

        Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}

package com.sam.automation.utils;

import com.sam.automation.config.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertUtils {

    private final WebDriverWait wait;

    public AlertUtils(WebDriver driver) {

        long timeout =
                ConfigReader.getLongProperty("explicitWait");

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout)
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

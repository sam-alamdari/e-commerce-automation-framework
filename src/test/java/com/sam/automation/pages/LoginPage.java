package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By loginModal = By.id("logInModal");
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton = By.xpath("//button[text()='Log in']");
    private final By welcomeMessage = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isLoginModalDisplayed() {
        return waitUtils.waitForDisplayed(loginModal);
    }

    public void enterUsername(String username) {
        waitUtils.waitForVisibility(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordField)
                .sendKeys(password);
    }

    public void clickLoginButton() {
        waitUtils.waitForClickable(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return waitUtils.waitForDisplayed(welcomeMessage);
    }

    public String getLoginAlertMessage() {

        Alert alert = waitUtils.waitForAlert();

        String message = alert.getText();

        alert.accept();

        return message;
    }
}

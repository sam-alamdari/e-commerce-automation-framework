package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By signUpModal = By.id("signInModal");
    private final By usernameField = By.id("sign-username");
    private final By passwordField = By.id("sign-password");
    private final By signUpButton = By.xpath("//button[text()='Sign up']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isSignUpModalDisplayed() {
        return waitUtils.waitForDisplayed(signUpModal);
    }

    public void enterUsername(String username) {
        waitUtils.waitForVisibility(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordField)
                .sendKeys(password);
    }

    public void clickSignUpButton() {
        waitUtils.waitForClickable(signUpButton)
                .click();
    }
}

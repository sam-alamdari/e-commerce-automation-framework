package com.sam.automation.pages;

import com.sam.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By loginLink = By.id("login2");
    private final By signUpLink = By.id("signin2");

    private final By samsungGalaxyS6 = By.xpath("//a[text()='Samsung galaxy s6']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    public LoginPage clickLogin(){
        waitUtils.waitForClickable(loginLink).click();

        return new LoginPage(driver);
    }
    public SignUpPage clickSignUp(){
        waitUtils.waitForClickable(signUpLink).click();
        return new SignUpPage(driver);
    }
    public ProductPage clickSamsungGalaxyS6(){
        waitUtils.waitForClickable(samsungGalaxyS6).click();
        return new ProductPage(driver);
    }

}

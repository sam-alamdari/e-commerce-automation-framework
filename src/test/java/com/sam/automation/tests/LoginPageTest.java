package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.data.TestData;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("Authentication")
    @Story("Verify login form")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"regression"})
    public void verifyLoginFields() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginModalDisplayed(),
                "Login modal should be displayed"
        );

        loginPage.enterUsername(TestData.TEST_USERNAME);
        loginPage.enterPassword(TestData.TEST_PASSWORD);
    }

    @Epic("E-Commerce")
    @Feature("Authentication")
    @Story("Successful user login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"smoke", "regression"})
    public void verifySuccessfulLogin() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

        loginPage.enterUsername(TestData.TEST_USERNAME);
        loginPage.enterPassword(TestData.TEST_PASSWORD);
        loginPage.clickLoginButton();

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login should be successful"
        );
    }
}
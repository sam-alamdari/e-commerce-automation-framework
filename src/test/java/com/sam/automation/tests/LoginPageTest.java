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
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][]{
                {TestData.TEST_USERNAME, "wrongPassword1", "Wrong password."},
                {TestData.TEST_USERNAME, "wrongPassword2", "Wrong password."},
                {TestData.TEST_USERNAME, "wrongPassword3", "Wrong password."}
        };
    }

    @Epic("E-Commerce")
    @Feature("Authentication")
    @Story("Invalid user login")
    @Severity(SeverityLevel.NORMAL)
    @Test(
            dataProvider = "invalidLoginData",
            groups = {"regression"}
    )
    public void verifyInvalidLogin(
            String username,
            String password,
            String expectedMessage) {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        String actualMessage =
                loginPage.getLoginAlertMessage();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Invalid login alert message is incorrect"
        );
    }
}
package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("Home Page")
    @Story("Open login modal from home page")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"regression"})
    public void verifyLoginLink() {

        HomePage homePage =
                new HomePage(driver);

        LoginPage loginPage =
                homePage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginModalDisplayed(),
                "Login modal should be displayed"
        );
    }
}
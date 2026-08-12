package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.SignUpPage;
import com.sam.automation.utils.AlertUtils;
import com.sam.automation.utils.TestDataGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("User Registration")
    @Story("Verify sign up form")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = {"regression"})
    public void verifySignUpModal() {

        HomePage homePage = new HomePage(driver);

        SignUpPage signUpPage =
                homePage.clickSignUp();

        Assert.assertTrue(
                signUpPage.isSignUpModalDisplayed(),
                "Sign Up modal should be displayed"
        );
    }

    @Epic("E-Commerce")
    @Feature("User Registration")
    @Story("Successful user registration")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"smoke", "regression"})
    public void verifySuccessfulSignUp() {

        HomePage homePage = new HomePage(driver);

        SignUpPage signUpPage =
                homePage.clickSignUp();

        String username =
                TestDataGenerator.generateUniqueUsername();

        String password =
                TestDataGenerator.getTestPassword();

        signUpPage.enterUsername(username);
        signUpPage.enterPassword(password);
        signUpPage.clickSignUpButton();

        AlertUtils alertUtils =
                new AlertUtils(driver);

        String alertText =
                alertUtils.getTextAndAccept();

        Assert.assertEquals(
                alertText,
                "Sign up successful.",
                "Sign up should be successful"
        );
    }
}
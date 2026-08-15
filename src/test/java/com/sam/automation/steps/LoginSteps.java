package com.sam.automation.steps;

import com.sam.automation.data.TestData;
import com.sam.automation.driver.DriverFactory;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {

        driver =
                DriverFactory.getDriver();

        homePage =
                new HomePage(driver);

        Assert.assertNotNull(
                driver,
                "WebDriver should be initialized"
        );
    }

    @When("the user opens the login form")
    public void theUserOpensTheLoginForm() {

        loginPage =
                homePage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginModalDisplayed(),
                "Login modal should be displayed"
        );
    }

    @When("the user enters valid login credentials")
    public void theUserEntersValidLoginCredentials() {

        loginPage.enterUsername(
                TestData.TEST_USERNAME
        );

        loginPage.enterPassword(
                TestData.TEST_PASSWORD
        );
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersUsernameAndPassword(
            String username,
            String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {

        loginPage.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login should be successful"
        );
    }

    @Then("the login error message should be {string}")
    public void theLoginErrorMessageShouldBe(
            String expectedMessage) {

        String actualMessage =
                loginPage.getLoginAlertMessage();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Login error message is incorrect"
        );
    }
}



package com.sam.automation.steps;

import com.sam.automation.config.ConfigReader;
import com.sam.automation.data.TestData;
import com.sam.automation.driver.DriverFactory;
import com.sam.automation.pages.HomePage;
import com.sam.automation.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void setup() {

        DriverFactory.initializeDriver();

        driver = DriverFactory.getDriver();

        driver.get(
                ConfigReader.getProperty("baseUrl")
        );

        homePage =
                new HomePage(driver);
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {

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

    @After
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}



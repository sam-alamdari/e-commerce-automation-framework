package com.sam.automation.tests;

import com.sam.automation.driver.DriverFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverFactoryTest {

    @Epic("E-Commerce")
    @Feature("Driver Management")
    @Story("Initialize Chrome WebDriver")
    @Severity(SeverityLevel.BLOCKER)
    @Test(groups = {"regression"})
    public void verifyChromeDriverInitialization() {

        DriverFactory.initializeDriver();

        Assert.assertNotNull(
                DriverFactory.getDriver(),
                "Chrome WebDriver should be initialized"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}
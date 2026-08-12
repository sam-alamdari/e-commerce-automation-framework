package com.sam.automation.base;

import com.sam.automation.config.ConfigReader;
import com.sam.automation.driver.DriverFactory;
import com.sam.automation.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    @BeforeMethod(alwaysRun = true)
    public void setup() {

        DriverFactory.initializeDriver();
        driver = DriverFactory.getDriver();
        String baseUrl =
                ConfigReader.getProperty("baseUrl");

        driver.get(baseUrl);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
        driver = null;
    }
}

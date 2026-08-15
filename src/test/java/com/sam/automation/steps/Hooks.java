package com.sam.automation.steps;

import com.sam.automation.config.ConfigReader;
import com.sam.automation.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setup() {

        DriverFactory.initializeDriver();

        WebDriver driver =
                DriverFactory.getDriver();

        driver.get(
                ConfigReader.getProperty("baseUrl")
        );
    }

    @After
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}


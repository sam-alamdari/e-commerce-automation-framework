package com.sam.automation.base;

import com.sam.automation.config.ConfigReader;
import com.sam.automation.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverFactory.initializeDriver();
        String baseUrl = ConfigReader.getProperty("baseUrl");
        DriverFactory.driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}

package com.sam.automation.tests;

import com.sam.automation.driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverFactoryTest {

    @Test
    public void verifyChromeDriverInitialization(){
        DriverFactory.initializeDriver();
        Assert.assertNotNull(DriverFactory.driver);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}

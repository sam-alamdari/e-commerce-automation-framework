package com.sam.automation.base;

import com.sam.automation.drivers.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverFactory.initializeDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.driver.quit();
    }
}

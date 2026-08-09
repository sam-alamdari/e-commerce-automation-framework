package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.driver.DriverFactory;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void openGoogle(){
        DriverFactory.driver.get("https://www.google.com");
    }
}

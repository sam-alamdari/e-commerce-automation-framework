package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import com.sam.automation.driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseUrlTest extends BaseTest {

    @Test
    public void verifyBaseUrl(){

        String currentUrl = DriverFactory.driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("demoblaze.com"),
                "Base URL was not loaded correctly."
        );
    }
}

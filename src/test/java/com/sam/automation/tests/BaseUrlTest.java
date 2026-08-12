package com.sam.automation.tests;

import com.sam.automation.base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseUrlTest extends BaseTest {

    @Epic("E-Commerce")
    @Feature("Application Navigation")
    @Story("Verify base URL")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"smoke"})
    public void verifyBaseUrl() {

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains(
                        "demoblaze.com"
                ),
                "Base URL was not loaded correctly."
        );
    }
}

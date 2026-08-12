package com.sam.automation.tests;

import com.sam.automation.config.ConfigReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Epic("E-Commerce")
    @Feature("Configuration Management")
    @Story("Load browser configuration")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"regression"})
    public void verifyConfigProperties() {

        String browser =
                ConfigReader.getProperty("browser");

        Assert.assertEquals(
                browser,
                "chrome",
                "Browser configuration should be chrome"
        );
    }
}
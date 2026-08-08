package com.sam.automation.tests;

import com.sam.automation.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void verifyConfigProperties(){
        String browser = ConfigReader.getProperty("browser");
        Assert.assertEquals(browser,"chrome");
    }

}

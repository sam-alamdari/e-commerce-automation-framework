package com.sam.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.sam.automation.steps",
        plugin = {
                "pretty"
        }
)
public class CucumberRunnerTest
        extends AbstractTestNGCucumberTests {
}
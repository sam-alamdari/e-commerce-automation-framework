package com.sam.automation.driver;

import com.sam.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() {

        if (driver != null) {
            return;
        }

        String browser =
                ConfigReader.getProperty("browser");

        boolean headless =
                ConfigReader.getBooleanProperty("headless");

        switch (browser.toLowerCase()) {

            case "chrome" -> {

                ChromeOptions options =
                        new ChromeOptions();

                options.addArguments(
                        "--window-size=1920,1080"
                );

                if (headless) {
                    options.addArguments(
                            "--headless=new"
                    );
                }

                driver =
                        new ChromeDriver(options);
            }

            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }

        long implicitWait =
                ConfigReader.getLongProperty("implicitWait");

        driver.manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(implicitWait)
                );
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

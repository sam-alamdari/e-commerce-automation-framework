package com.sam.automation.driver;

import com.sam.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver driver;

    public static void initializeDriver(){

       String browser = ConfigReader.getProperty("browser");
       if (browser.equalsIgnoreCase("chrome")){
           ChromeOptions options = new ChromeOptions();
           String headless = ConfigReader.getProperty("headless");
           if (Boolean.parseBoolean(headless)){
               options.addArguments("--headless=new");
           }
        driver = new ChromeDriver(options);
    }
        String implicitWait = ConfigReader.getProperty("implicitWait");

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(implicitWait))
        );
    }
    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}

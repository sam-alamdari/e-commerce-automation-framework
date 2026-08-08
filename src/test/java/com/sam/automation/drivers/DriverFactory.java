package com.sam.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver driver;

    public static void initializeDriver(){
        driver = new ChromeDriver();
    }
}

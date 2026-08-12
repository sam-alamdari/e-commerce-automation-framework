package com.sam.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(
            WebDriver driver,
            String screenshotName) {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter
                                        .ofPattern("yyyyMMdd_HHmmss")
                        );

        String screenshotPath =
                "target/screenshots/"
                        + screenshotName
                        + "_"
                        + timestamp
                        + ".png";

        File destination =
                new File(screenshotPath);

        try {
            FileUtils.copyFile(
                    source,
                    destination
            );
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to save screenshot: "
                            + screenshotPath,
                    e
            );
        }

        return screenshotPath;
    }
}

package com.sam.automation.listeners;

import com.sam.automation.base.BaseTest;
import com.sam.automation.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener, IInvokedMethodListener {


    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "TEST STARTED: "
                        + result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "TEST PASSED: "
                        + result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "TEST FAILED: "
                        + result.getMethod().getMethodName()
        );
    }

    @Override
    public void afterInvocation(
            IInvokedMethod method,
            ITestResult result) {

        if (!method.isTestMethod()
                || result.isSuccess()) {

            return;
        }

        Object testInstance =
                result.getInstance();

        if (!(testInstance instanceof BaseTest)) {
            return;
        }

        BaseTest baseTest =
                (BaseTest) testInstance;

        WebDriver driver =
                baseTest.getDriver();

        if (driver == null) {
            return;
        }

        ScreenshotUtils.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );

        byte[] screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Failure Screenshot",
                "image/png",
                new ByteArrayInputStream(screenshot),
                ".png"
        );
    }
}

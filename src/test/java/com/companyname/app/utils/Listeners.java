package com.companyname.app.utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.ByteArrayInputStream;
import java.util.UUID;

public class Listeners extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Executing listener on failure");

        // Retrieve Appium driver instance
        AppiumDriver<?> driver = (AppiumDriver<?>) result.getTestContext().getAttribute("driver");

        if (driver != null) {
            try {
                // Capture and attach screenshot to Allure report
                Allure.addAttachment(
                        "Screenshot on Failure - " + UUID.randomUUID(),
                        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES))
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Appium Driver instance is null. Screenshot cannot be taken.");
        }
    }
}
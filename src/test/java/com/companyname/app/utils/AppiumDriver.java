package com.companyname.app.utils;

import com.companyname.app.pages.LoginPage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriver {
    public static io.appium.java_client.AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public static LoginPage loginPage;

    public static String platformName() {
        return "android";
    }

    @BeforeSuite
    public void setup(ITestContext context) throws InterruptedException, MalformedURLException {

        AppiumConfiguration.StartAppiumServer();
        String platformName = platformName();

        if (platformName.equals("ios")) {
           /*
           In the future :)
            */
        } else if (platformName.equals("android")) {
            String PROJECT_ROOT = System.getProperty("user.dir");
            String ANDROID_APK_PATH = "/src/test/resources/apps/android.wdio.native.app.v1.0.8.apk";

            // Update the values as per your environment
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "Samsung Galaxy S22 API 31");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "12.0.0");
            caps.setCapability("app", new File(PROJECT_ROOT + ANDROID_APK_PATH).getAbsolutePath());
            caps.setCapability("appPackage", "com.wdiodemoapp");
            caps.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
            caps.setCapability("noReset", true);
            caps.setCapability("fullReset", false);

            driver = new io.appium.java_client.AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            wait = new WebDriverWait(driver, 120);
            context.setAttribute("driver", driver);

            loginPage = new LoginPage(driver,wait);
        }
    }

    @AfterSuite
    public void teardown() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("fullReset", true);
        driver.quit();
    }
}

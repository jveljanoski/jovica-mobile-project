package com.companyname.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwipePage {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    // Locators
    private By swipeButton = MobileBy.AccessibilityId("Swipe");
    private By getPageTitle = MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
    private By getPostSwipeText = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[1]/android.widget.TextView[1]");
    private By getSecondPostSwipeText = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[1]/android.widget.TextView[2]");

    // Constructor
    public SwipePage(AppiumDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Click Swipe Button")
    public void clickOnSwipeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(swipeButton)).click();
    }

    @Step("Swipe Left")
    public void swipeLeftWithTouchAction() {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;
        int startX = (int) (screenWidth * 0.8);
        int endX = (int) (screenWidth * 0.2);
        int y = screenHeight / 2;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    @Step("Swipe Right")
    public void swipeRightWithTouchAction() {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;
        int startX = (int) (screenWidth * 0.2);
        int endX = (int) (screenWidth * 0.8);
        int y = screenHeight / 2;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    @Step("Get Page Title")
    public String getPageTitle(){
        return wait.until(ExpectedConditions.elementToBeClickable(getPageTitle)).getText();
    }

    @Step("Fetch text after the swipe")
    public String getPostSwipeText() {
        return wait.until(ExpectedConditions.elementToBeClickable(getPostSwipeText)).getText();
    }

    @Step("Verify a specific element is displayed after the swipe")
    public boolean isSpecificElementDisplayed() {
        return wait.until(ExpectedConditions.elementToBeClickable(getSecondPostSwipeText)).isDisplayed();
    }

}

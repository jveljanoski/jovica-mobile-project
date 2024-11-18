package com.companyname.app.tests;

import com.companyname.app.utils.AppiumDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SwipeTest extends AppiumDriver {


    @Test(description = "Click on the swipe button")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Click on the swipe button")
    @Description("Verifies that the swipe button is clickable")
    public void testClickSwipe() throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        swipePage.clickOnSwipeButton();
        String expectedTitle = "Swipe horizontal1";
        String actualTitle = swipePage.getPageTitle();
        System.out.println(swipePage.getPageTitle());
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @Test(dependsOnMethods = "testClickSwipe", description = "Swipe right")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the swipe right works as expected")
    public void testSwipeRightWithTouchAction() {
        SoftAssert softAssert = new SoftAssert();
        swipePage.swipeLeftWithTouchAction();
        String expectedTitle = "GREAT COMMUNITY";
        String actualTitle = swipePage.getPostSwipeText();
        softAssert.assertEquals(actualTitle,expectedTitle,"Swipe right did not work as expected");
        boolean isElementDisplayed = swipePage.isSpecificElementDisplayed();
        softAssert.assertTrue(isElementDisplayed,"The Specific element is not displayed after swipe right");
        softAssert.assertAll();
    }
}

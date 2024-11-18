package com.companyname.app.tests;

import com.companyname.app.utils.AppiumDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginTest extends AppiumDriver {

    @Test(description = "Click on the Login button")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Click on the Login button")
    @Description("Verifies that the Login button is clickable")
    public void testClickLogin() {
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "testClickLogin", description = "Open the Sign Up form")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the Sign Up form can be opened")
    public void testOpenSignUpForm() {
        loginPage.openSignUpForm();
    }

    @Test(dependsOnMethods = "testOpenSignUpForm", description = "Enter the email address")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the email address can be entered")
    public void testEnterEmail() {
        loginPage.enterEmail("test@example.com");
    }

    @Test(dependsOnMethods = "testEnterEmail", description = "Enter the password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the password can be entered")
    public void testEnterPassword() {
        loginPage.enterPassword("password123");
    }

    @Test(dependsOnMethods = "testEnterPassword", description = "Confirm the password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the password confirmation can be entered")
    public void testConfirmPassword() {
        loginPage.confirmPassword("password123");
    }

    @Test(dependsOnMethods = "testConfirmPassword", description = "Complete the Sign Up process")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the Sign Up process can be completed")
    public void testCompleteSignUp() {
        loginPage.completeSignUp();
    }

    @Test(dependsOnMethods = "testCompleteSignUp", description = "Click the OK button on Sign Up confirmation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that the OK button can be clicked after successful Sign Up")
    public void testClickSignUpOKButton() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        loginPage.clickSignUpOKButton();
    }
}

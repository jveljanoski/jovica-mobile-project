package com.companyname.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Locators
    private By loginButton = MobileBy.AccessibilityId("Login");
    private By signUpFormButton = MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup");
    private By emailField = MobileBy.AccessibilityId("input-email");
    private By passwordField = MobileBy.AccessibilityId("input-password");
    private By confirmPasswordField = MobileBy.AccessibilityId("input-repeat-password");
    private By signUpButton = MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup");
    private By signUpOKButton = MobileBy.id("android:id/button1");


    // Constructor
    public LoginPage(AppiumDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Click Login Button")
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Open Sign Up form")
    public void openSignUpForm(){
        wait.until(ExpectedConditions.elementToBeClickable(signUpFormButton)).click();
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }
    @Step("Enter password")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    @Step("Confirm password")
    public void confirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
    }

    @Step("Complete the Sign Up process")
    public void completeSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    @Step("Click OK button on Sign Up confirmation")
    public void clickSignUpOKButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpOKButton)).click();
    }
}

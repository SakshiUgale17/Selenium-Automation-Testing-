package com.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ForgotPasswordValidation {
    WebDriver driver;
    WebDriverWait wait;

    public ForgotPasswordValidation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/app-root/login/abx-auth-container/div/div[2]/div/abx-login/div/a")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id='id_17364173266215197']")
    WebElement emailInputField;

    @FindBy(xpath = "//*[@title='Proceed']")
    WebElement proceedButton;

    @FindBy(xpath = "//*[contains(text(),'Reset link sent to your email')]") // Update based on actual UI
    WebElement successMessage;

    public void validateForgotPassword(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
        wait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();

        // Validation
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertEquals(successMessage.getText(), "Reset link sent to your email", "Forgot password failed!");
    }
}

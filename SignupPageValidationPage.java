package com.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class SignupPageValidation {
    WebDriver driver;
    WebDriverWait wait;

    public SignupPageValidation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='slds-float_right']/a")
    WebElement signupButton;

    @FindBy(xpath = "//*[@id='id_17364210188447499']")
    WebElement emailField;

    @FindBy(xpath = "//*[@id='modal-content-id-1']/abx-sign-up/div/div/div[2]/span/div[2]/abx-button/button")
    WebElement proceedButton;

    @FindBy(xpath = "//*[contains(text(),'Account created successfully!')]") // Update based on actual UI
    WebElement successMessage;

    public void validateSignup(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();

        // Validation
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertEquals(successMessage.getText(), "Account created successfully!", "Signup failed!");
    }
}

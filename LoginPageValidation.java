package com.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginPageValidation {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPageValidation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@autocomplete='new-password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@title='Log In']")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Invalid username or password')]") // Update based on actual UI
    WebElement errorMessage;

    public void validateLogin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        // Validation
        if (username.equals("validUser") && password.equals("validPass")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed!");
        } else {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid login!");
        }
    }
}

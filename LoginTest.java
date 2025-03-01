package com.Tests;

import org.testng.annotations.Test;
import com.AllPages.LoginPageValidation;
import com.Base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPageValidation login = new LoginPageValidation(driver);
        login.validateLogin("validUser", "validPass");
    }
}

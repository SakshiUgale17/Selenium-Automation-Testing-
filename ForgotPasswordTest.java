package com.Tests;

import org.testng.annotations.Test;
import com.AllPages.ForgotPasswordValidation;
import com.Base.BaseTest;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void testForgotPassword() {
        ForgotPasswordValidation forgotPassword = new ForgotPasswordValidation(driver);
        forgotPassword.validateForgotPassword("testemail@example.com");
    }
}

package com.Tests;

import org.testng.annotations.Test;
import com.AllPages.SignupPageValidation;
import com.Base.BaseTest;

public class SignupTest extends BaseTest {

    @Test
    public void testSignup() {
        SignupPageValidation signup = new SignupPageValidation(driver);
        signup.validateSignup("testemail@example.com");
    }
}

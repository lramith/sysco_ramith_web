package com.sysco.ramith_web.tests;


import com.sysco.ramith_web.functions.Login;
import com.sysco.ramith_web.utils.LoginUtil;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class InvalidLoginTest extends LoginUtil {

    private static final String INVALID_USERNAME_ERROR_MSG = "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.";
    private static final String BLANK_USERNAME_PASSWORD_ERROR = "THIS IS A REQUIRED FIELD.";
    private Login login;

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Online Shopping - InvalidLoginTest");
        login = initializeLogin();
    }

    @Test
    public void testInvalidLogin() throws RuntimeException {
        Assert.assertTrue(login.isLoginHyperLinkDisplayed(), "Login hyperlink should display in the home page");
        login.logInWithOutCredentials();
        Assert.assertEquals(login.getUserNameErrorMessage(), BLANK_USERNAME_PASSWORD_ERROR);
        Assert.assertEquals(login.getPasswordErrorMessage(), BLANK_USERNAME_PASSWORD_ERROR);
        Assert.assertEquals(login.logInWithInvalidCredentials(loginData.getInvalidUserName(), loginData.getPassword()), INVALID_USERNAME_ERROR_MSG);
    }

    @AfterClass
    public void closeBrowser() {
        login.quiteDriver();
    }
}
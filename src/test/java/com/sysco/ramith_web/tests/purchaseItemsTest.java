package com.sysco.ramith_web.tests;


import com.sysco.ramith_web.data.LoginData;
import com.sysco.ramith_web.functions.Login;
import com.sysco.ramith_web.functions.Sales;
import com.sysco.ramith_web.utils.ExcelUtil;
import com.sysco.ramith_web.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class purchaseItemsTest extends TestBase {

    private Login login;
    private Sales sales;
    private LoginData loginData;
    private static final String LOGGED_IN_USER = "WILLIAM JACOB";
    private static final String INVALID_USERNAME_ERROR_MSG = "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.";
    private static final String BLANK_USERNAME_PASSWORD_ERROR = "THIS IS A REQUIRED FIELD.";


    @BeforeTest
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
        loginData = ExcelUtil.getLoginData("$as238l");
        login = new Login();
        sales = new Sales();
    }

    @Test
    public void testPurchasing() throws RuntimeException{
        login.loadLoginPage();
        Assert.assertTrue(login.isLoginHyperLinkDisplayed(), "Login hyperlink should display in the home page");
        Assert.assertEquals(login.logInToApplication(loginData.getUserName(), loginData.getPassword()), LOGGED_IN_USER, "User should be able to login to the application");
        Assert.assertTrue(sales.emptyExistingCart(), "User should be able to empty existing cart");
        Assert.assertTrue(sales.navigateToRandomProduct(), "User should be able access random product");

    }

    @Test
    public void testInvalidLogin() throws RuntimeException {
        login.loadLoginPage();
        Assert.assertTrue(login.isLoginHyperLinkDisplayed(), "Login hyperlink should display in the home page");
        login.logInWithOutCredentials();
        Assert.assertEquals(login.getUserNameErrorMessage(), BLANK_USERNAME_PASSWORD_ERROR);
        Assert.assertEquals(login.getPasswordErrorMessage(), BLANK_USERNAME_PASSWORD_ERROR);
        Assert.assertEquals(login.logInWithInvalidCredentials(loginData.getInvalidUserName(), loginData.getPassword()), INVALID_USERNAME_ERROR_MSG);
    }

    @AfterTest
    public void closeBrowser () {
        login.quiteDriver();
    }
}
package com.sysco.ramith_web.tests;


import com.sysco.ramith_web.functions.Checkout;
import com.sysco.ramith_web.functions.Product;
import com.sysco.ramith_web.functions.Sales;
import com.sysco.ramith_web.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class purchaseItemsTest extends TestBase {


    private static final String INVALID_USERNAME_ERROR_MSG = "YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.";
    private static final String BLANK_USERNAME_PASSWORD_ERROR = "THIS IS A REQUIRED FIELD.";
    private Sales sales;
    private Product product;
    private Checkout checkout;

    @BeforeTest
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Purchase an Item");
        initializeLogin();
        sales = new Sales();
        product = new Product();
        checkout = new Checkout();
    }

    @Test
    public void testLogin() throws RuntimeException {
        Assert.assertTrue(login.isLoginHyperLinkDisplayed(), "Login hyperlink should display in the home page");
        Assert.assertEquals(login.logInToApplication(loginData.getUserName(), loginData.getPassword()), loginData.getName(), "User should be able to login to the application");

    }

    @Test(dependsOnMethods = "testLogin")
    public void testPurchasing() throws RuntimeException {
        sales.emptyExistingCart();
        Assert.assertTrue(sales.navigateToRandomProduct(), "User should be able access random product");
        product.selectAvailableSize();
        product.storeProductNameAndPrice();
        product.addProductToCart();
        Assert.assertEquals(product.getAddToCartSuccessMessage(), product.getSuccessMessage(), "Product should be successfully added");
        sales.viewCart();
        Assert.assertEquals(sales.getCartProductName(), product.getAddedProductName(), "Product name should be same as added product");
        Assert.assertEquals(sales.getCartProductPrice(), product.getAddedProductPrice(), "Product name should be same as added product");
    }

    @Test(dependsOnMethods = "testPurchasing")
    public void testCheckout() throws RuntimeException {
        checkout.clickOnProceedToCheckout();
        Assert.assertEquals(checkout.getFirstName(), "");
        Assert.assertEquals(checkout.getLastName(), "");
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getCityRequiredErrorMessage(), "");
        Assert.assertEquals(checkout.getStateRequiredErrorMessage(), "");
        Assert.assertEquals(checkout.getPostCodeRequiredErrorMessage(), "");
        Assert.assertEquals(checkout.getPhoneRequiredErrorMessage(), "");
        checkout.setPostCode("");
        checkout.setAddress("");
        checkout.setPhone("");
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getSecureCheckoutHeading(), "");
        checkout.selectPaymentMethodAsCreditCard();
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getInvalidCreditCardError(), "");
        checkout.setCreditCardNumber("");
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getInvalidCreditCardMonthError(), "");
        Assert.assertEquals(checkout.getInvalidCreditCardYearError(), "");

    }

    @Test
    public void testInvalidLogin() throws RuntimeException {
        login.loadLoginPage();
        try {
            Assert.assertTrue(login.isLoginHyperLinkDisplayed(), "Login hyperlink should display in the home page");
            login.logInWithOutCredentials();
            Assert.assertEquals(login.getUserNameErrorMessage(), BLANK_USERNAME_PASSWORD_ERROR);
            Assert.assertEquals(login.getPasswordErrorMessage(), BLANK_USERNAME_PASSWORD_ERROR);
            Assert.assertEquals(login.logInWithInvalidCredentials(loginData.getInvalidUserName(), loginData.getPassword()), INVALID_USERNAME_ERROR_MSG);
        } finally {
            login.quiteDriver();
        }
    }

    @AfterClass
    public void closeBrowser() {
        login.quiteDriver();
    }
}
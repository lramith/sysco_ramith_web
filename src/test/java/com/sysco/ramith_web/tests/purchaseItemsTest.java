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
    private static final String REQUIRED_FIELD_ERROR_MESSAGE = "THIS IS A REQUIRED FIELD.";
    private static final String SECURE_CHECKOUT_HEADING = "SECURE CHECKOUT";
    private static final String INVALID_CREDIT_CARD_ERROR = "PLEASE, ENTER VALID CREDIT CARD NUMBER";
    private static final String VALID_EXPIRATION_MONTH_ERROR = "PLEASE, ENTER VALID EXPIRATION DATE";
    private static final String VALID_EXPIRATION_YEAR_ERROR = "PLEASE, ENTER VALID EXPIRATION DATE";
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
        checkout.clickOnProceedToCheckout();
        Assert.assertEquals(checkout.getFirstName(), loginData.getFirstName());
        Assert.assertEquals(checkout.getLastName(), loginData.getLastName());
        checkout.clickOnContinue();
//        Assert.assertEquals(checkout.getCityRequiredErrorMessage(), REQUIRED_FIELD_ERROR_MESSAGE);
//        Assert.assertEquals(checkout.getStateRequiredErrorMessage(), REQUIRED_FIELD_ERROR_MESSAGE);
//        Assert.assertEquals(checkout.getPostCodeRequiredErrorMessage(), REQUIRED_FIELD_ERROR_MESSAGE);
//        Assert.assertEquals(checkout.getPhoneRequiredErrorMessage(), REQUIRED_FIELD_ERROR_MESSAGE);
        checkout.setPostCode(loginData.getPostCode());
        checkout.setAddress(loginData.getAddress());
        checkout.setPhone(loginData.getPhoneNumber());
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getSecureCheckoutHeading(), SECURE_CHECKOUT_HEADING);
        checkout.selectPaymentMethodAsCreditCard();
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getInvalidCreditCardError(), INVALID_CREDIT_CARD_ERROR);
        checkout.setCreditCardNumber(loginData.getCreditCard());
        checkout.clickOnContinue();
        Assert.assertEquals(checkout.getInvalidCreditCardMonthError(), VALID_EXPIRATION_MONTH_ERROR);
        Assert.assertEquals(checkout.getInvalidCreditCardYearError(), VALID_EXPIRATION_YEAR_ERROR);

    }

    @Test
    public void testInvalidLogin() throws RuntimeException {
        login.loadLoginPage();
        try {
            Assert.assertTrue(login.isLoginHyperLinkDisplayed(), "Login hyperlink should display in the home page");
            login.logInWithOutCredentials();
            Assert.assertEquals(login.getUserNameErrorMessage(), REQUIRED_FIELD_ERROR_MESSAGE);
            Assert.assertEquals(login.getPasswordErrorMessage(), REQUIRED_FIELD_ERROR_MESSAGE);
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
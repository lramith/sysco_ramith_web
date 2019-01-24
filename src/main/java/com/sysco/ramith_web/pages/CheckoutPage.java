package com.sysco.ramith_web.pages;

import org.openqa.selenium.By;

import static com.sysco.ramith_web.pages.LogInPage.syscoLabUIOgm;

/**
 * This class provide page level functions and the elements for the login page
 */
public class CheckoutPage {
    private By btnProceedToCheckout = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[2]/div[1]/div/button");
    private By lblSecureCheckout = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    private By txtFirstName = By.id("OSUWM4X");
    private By txtLastName = By.id("EFQE1SC");
    private By btnContinue = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[3]/button");
    private By lblCityRequiredField = By.xpath("//*[@id=\"error-AQ99XG4\"]/span");
    private By lblStateRequiredField = By.xpath("//*[@id=\"error-GYD2P77\"]/span");
    private By lblPostCodeRequiredField = By.xpath("//*[@id=\"error-C53AN22\"]/span");
    private By lblPhoneRequiredField = By.xpath("//*[@id=\"error-RE4DNMK\"]/span");
    private By txtPostCode = By.id("C53AN22");
    private By drpFirstPostCode = By.id("ui-id-3");
    private By txtAddressLine = By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div[1]/div");
    private By txtPhoneNumber = By.id("RE4DNMK");
    private By rdBtnCreditCardPay = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label");
    private By lblValidCreditCardRequiredError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[2]/div/div[2]/span");
    private By txtCreditCardNumber = By.id("braintree-hosted-field-number");
    private By lblCreditCardInvalidMonthError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[1]/div[2]/span");
    private By lblCreditCardInvalidYearError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[2]/div[2]/span");

    public void clickProceedToCheckout() {
        syscoLabUIOgm.click(btnProceedToCheckout);
    }

    public boolean isSecureCheckoutHeadingDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblSecureCheckout);
    }

    public String getSecureCheckoutHeading() {
        return syscoLabUIOgm.getText(lblSecureCheckout);
    }

    public String getFirstName() {
        return syscoLabUIOgm.getText(txtFirstName);
    }

    public String getLastName() {
        return syscoLabUIOgm.getText(txtLastName);
    }

    public void clickContinue() {
        syscoLabUIOgm.click(btnContinue);
    }

    public boolean isCityRequiredFieldErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblCityRequiredField);
    }

    public String getCityRequiredFieldError() {
        return syscoLabUIOgm.getText(lblCityRequiredField);
    }

    public boolean isStateRequiredFieldErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblStateRequiredField);
    }

    public String getStateRequiredFieldError() {
        return syscoLabUIOgm.getText(lblStateRequiredField);
    }

    public boolean isPostCodeRequiredFieldErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblPostCodeRequiredField);
    }

    public String getPostCodeRequiredFieldError() {
        return syscoLabUIOgm.getText(lblPostCodeRequiredField);
    }

    public boolean isPhoneRequiredFieldDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblPhoneRequiredField);
    }

    public String getPhoneRequiredFieldError() {
        return syscoLabUIOgm.getText(lblPhoneRequiredField);
    }

    public void setPostCode(String postCode) {
        syscoLabUIOgm.sendKeys(txtPostCode, postCode);
    }

    public void selectFirstPostCode() {
        syscoLabUIOgm.click(drpFirstPostCode);
    }

    public void setAddressLine(String address) {
        syscoLabUIOgm.sendKeys(txtAddressLine, address);
    }

    public void setPhoneNumber(String phoneNumber) {
        syscoLabUIOgm.sendKeys(txtPhoneNumber, phoneNumber);
    }

    public void selectCreditCardPay() {
        syscoLabUIOgm.click(rdBtnCreditCardPay);
    }

    public boolean isValidCreditCardRequiredErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblValidCreditCardRequiredError);
    }

    public String getValidCreditCardRequiredError() {
        return syscoLabUIOgm.getText(lblValidCreditCardRequiredError);
    }

    public void setValidCreditCardNumber(String creditCardNumber) {
        syscoLabUIOgm.sendKeys(txtCreditCardNumber, creditCardNumber);
    }

    public boolean isCreditCardInvalidMonthErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblCreditCardInvalidMonthError);
    }

    public String getCreditCardInvalidMonthError() {
        return syscoLabUIOgm.getText(lblCreditCardInvalidMonthError);
    }

    public boolean isCreditCardInvalidYearErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblCreditCardInvalidYearError);
    }

    public String getCreditCardInvalidYearError() {
        return syscoLabUIOgm.getText(lblCreditCardInvalidYearError);
    }
}

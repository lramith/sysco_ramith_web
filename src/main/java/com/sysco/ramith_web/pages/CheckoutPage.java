package com.sysco.ramith_web.pages;

import org.openqa.selenium.By;

import static com.sysco.ramith_web.pages.LogInPage.syscoLabUIOgm;

/**
 * This class provide page level functions and the elements for the login page
 */
public class CheckoutPage {
    private By btnProceedToCheckout = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[2]/div[1]/div/button");
    private By lblSecureCheckout = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    private By lstTextBoxes = By.cssSelector(".input-text");
    private By btnContinue = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div[3]/button");
    private By lblCityRequiredField = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/div[@class=\"field-error mage-error\"]/span");
    private By lblStateRequiredField = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[5]/div/div[@class=\"field-error mage-error\"]/span");
    private By lblPostCodeRequiredField = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[7]/div/div[@class=\"field-error mage-error\"]/span");
    private By lblPhoneRequiredField = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[9]/div/div[2]/div/div[@class=\"field-error\"]/span");
    private By drpFirstPostCode = By.id("ui-id-3");
    private By lblCreditCardPay = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label/strong");
    private By rdBtnCreditCardPay = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[1]/label");
    private By lblValidCreditCardRequiredError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[2]/div/div[2]/span");
    private By iFrameCardNumber = By.id("braintree-hosted-field-number");
    private By txtCreditCardNumber = By.id("credit-card-number");
    private By lblCreditCardInvalidMonthError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[1]/div[2]/span");
    private By lblCreditCardInvalidYearError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[2]/div[2]/span");

    public void clickProceedToCheckout() {
        syscoLabUIOgm.click(btnProceedToCheckout);
    }

    public void waitUntilThePageLoad() {
        syscoLabUIOgm.waitTillElementLoaded(lblSecureCheckout);
    }

    public boolean isSecureCheckoutHeadingDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblSecureCheckout);
    }

    public String getSecureCheckoutHeading() {
        return syscoLabUIOgm.getText(lblSecureCheckout);
    }

    public int getNumberOfTextBoxesLoadedInThePage() {
        return syscoLabUIOgm.findElements(lstTextBoxes).size();
    }

    public String getFirstName() {
        return syscoLabUIOgm.getAttribute(syscoLabUIOgm.findElements(lstTextBoxes).get(0), "value");
    }

    public String getLastName() {
        return syscoLabUIOgm.getAttribute(syscoLabUIOgm.findElements(lstTextBoxes).get(1), "value");
    }

    public void waitUntilContinueButtonLoads() {
        syscoLabUIOgm.waitTillElementLoaded(btnContinue);
    }

    public void clickContinue() {
        syscoLabUIOgm.click(syscoLabUIOgm.findElement(btnContinue));
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
        syscoLabUIOgm.sendKeys(syscoLabUIOgm.findElements(lstTextBoxes).get(7), postCode);
    }

    public void waitUntilDropDownExpand() {
        syscoLabUIOgm.waitTillElementLoaded(drpFirstPostCode);
    }

    public void selectFirstPostCode() {
        syscoLabUIOgm.click(drpFirstPostCode);
    }

    public void setAddressLine(String address) {
        syscoLabUIOgm.sendKeys(syscoLabUIOgm.findElements(lstTextBoxes).get(3), address);
    }

    public void setPhoneNumber(String phoneNumber) {
        syscoLabUIOgm.sendKeys(syscoLabUIOgm.findElements(lstTextBoxes).get(8), phoneNumber);
    }

    public void waitUntilPaymentMethodsLoad() {
        syscoLabUIOgm.waitTillElementLoaded(lblCreditCardPay);
    }

    public void waitUntilCreditCardPaymentFieldsLoad() {
        syscoLabUIOgm.waitTillElementLoaded(iFrameCardNumber);
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

    public void switchToDefaultFrame() {
        syscoLabUIOgm.switchToDefaultFrame();
    }

    public void switchToIFrameNumber() {
        syscoLabUIOgm.switchToFrame(iFrameCardNumber);
    }

    public void clickOnCreditCardFiled() {
        syscoLabUIOgm.click(txtCreditCardNumber);
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

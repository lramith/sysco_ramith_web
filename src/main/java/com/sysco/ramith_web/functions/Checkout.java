package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.pages.CheckoutPage;

/**
 * This class provide functions related to checkout
 */
public class Checkout {

    private static CheckoutPage checkoutPage = new CheckoutPage();

    public void clickOnProceedToCheckout() {
        checkoutPage.clickProceedToCheckout();
        checkoutPage.waitUntilThePageLoad();
    }

    public String getSecureCheckoutHeading() {
        if (checkoutPage.isSecureCheckoutHeadingDisplayed()) {
            return checkoutPage.getSecureCheckoutHeading();
        }
        return null;
    }

    public int getNumberOfTextBoxesLoaded() {
        return checkoutPage.getNumberOfTextBoxesLoadedInThePage();
    }

    public String getFirstName() {
        return checkoutPage.getFirstName();
    }

    public String getLastName() {
        return checkoutPage.getLastName();
    }

    public void clickOnContinue() {
        checkoutPage.waitUntilContinueButtonLoads();
        checkoutPage.clickContinue();
    }

    public String getCityRequiredErrorMessage() {
        if (checkoutPage.isCityRequiredFieldErrorDisplayed()) {
            return checkoutPage.getCityRequiredFieldError();
        }
        return null;
    }

    public String getStateRequiredErrorMessage() {
        if (checkoutPage.isStateRequiredFieldErrorDisplayed()) {
            return checkoutPage.getStateRequiredFieldError();
        }
        return null;
    }

    public String getPostCodeRequiredErrorMessage() {
        if (checkoutPage.isPostCodeRequiredFieldErrorDisplayed()) {
            return checkoutPage.getPostCodeRequiredFieldError();
        }
        return null;
    }

    public String getPhoneRequiredErrorMessage() {
        if (checkoutPage.isPhoneRequiredFieldDisplayed()) {
            return checkoutPage.getPhoneRequiredFieldError();
        }
        return null;
    }

    public void setAddress(String address) {
        checkoutPage.setAddressLine(address);
    }

    public void setPostCode(String postCode) {
        checkoutPage.setPostCode(postCode);
    }

    public void selectFirstPostCodeFromDropDown() {
        checkoutPage.waitUntilDropDownExpand();
        checkoutPage.selectFirstPostCode();
    }

    public void setPhone(String phone) {
        checkoutPage.setPhoneNumber(phone);
    }

    public void selectPaymentMethodAsCreditCard() {
        checkoutPage.waitUntilPaymentMethodsLoad();
        checkoutPage.selectCreditCardPay();
        checkoutPage.waitUntilCreditCardPaymentFieldsLoad();
    }

    public String getInvalidCreditCardError() {
        if (checkoutPage.isValidCreditCardRequiredErrorDisplayed()) {
            return checkoutPage.getValidCreditCardRequiredError();
        }
        return null;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        checkoutPage.switchToIFrameNumber();
        checkoutPage.clickOnCreditCardFiled();
        checkoutPage.setValidCreditCardNumber(creditCardNumber);
        checkoutPage.switchToDefaultFrame();
    }

    public String getInvalidCreditCardMonthError() {
        if (checkoutPage.isCreditCardInvalidMonthErrorDisplayed()) {
            return checkoutPage.getCreditCardInvalidMonthError();
        }
        return null;
    }

    public String getInvalidCreditCardYearError() {
        if (checkoutPage.isCreditCardInvalidYearErrorDisplayed()) {
            return checkoutPage.getCreditCardInvalidYearError();
        }
        return null;
    }

}

package com.sysco.ramith_web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    private By lblCreditCardInvalidMonthError = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[1]/div[2]/span");
    private By lblCreditCardInvalidMonth = By.xpath("//*[@id=\"payment_form_braintree\"]/div[3]/div/div[2]/div[2]/span");

    public By getBtnProceedToCheckout() {
        return btnProceedToCheckout;
    }

    public By getLblSecureCheckout() {
        return lblSecureCheckout;
    }

    public By getTxtFirstName() {
        return txtFirstName;
    }

    public By getTxtLastName() {
        return txtLastName;
    }

    public By getBtnContinue() {
        return btnContinue;
    }

    public By getLblCityRequiredField() {
        return lblCityRequiredField;
    }

    public By getLblStateRequiredField() {
        return lblStateRequiredField;
    }

    public By getLblPostCodeRequiredField() {
        return lblPostCodeRequiredField;
    }

    public By getLblPhoneRequiredField() {
        return lblPhoneRequiredField;
    }

    public By getTxtPostCode() {
        return txtPostCode;
    }

    public By getDrpFirstPostCode() {
        return drpFirstPostCode;
    }

    public By getTxtAddressLine() {
        return txtAddressLine;
    }

    public By getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public By getRdBtnCreditCardPay() {
        return rdBtnCreditCardPay;
    }

    public By getLblValidCreditCardRequiredError() {
        return lblValidCreditCardRequiredError;
    }

    public By getLblCreditCardInvalidMonthError() {
        return lblCreditCardInvalidMonthError;
    }

    public By getLblCreditCardInvalidMonth() {
        return lblCreditCardInvalidMonth;
    }
}

package com.sysco.ramith_web.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * This class provide page level functions and the elements for the login page
 */
public class LogInPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By lnkLogin = By.xpath("//header/div[1]/div[1]/ul/li[1]");
    private By txtUserName = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");
    private By lblErrorUserName = By.id("email-error");
    private By lblPassword = By.id("pass-error");
    private By lblInvalidCredentials = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[1]/div/div");
    private By btnForgotPw = By.xpath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a/span");
    private By lnkLoggedInName = By.xpath("//header/div[1]/div[1]/ul/li[2]/span/span");


    public static void loadAthletesPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }

    public boolean isLoginHyperLinkDisplayed() {
        return syscoLabUIOgm.isDisplayed(lnkLogin);
    }

    public void clickOnLoginLink() {
        syscoLabUIOgm.click(lnkLogin);
    }

    public void enterUserName(String userName) {
        syscoLabUIOgm.sendKeys(txtUserName, userName);
    }

    public void enterPassword(String password) {
        syscoLabUIOgm.sendKeys(txtPassword, password);
    }

    public void clickOnLoginButton() {
        syscoLabUIOgm.click(btnLogin);
    }

    public boolean isUserNameErrorMessageDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblErrorUserName);
    }

    public String getUserNameErrorMessage() {
        return syscoLabUIOgm.getText(lblErrorUserName);
    }

    public boolean isPasswordErrorMessageDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblPassword);
    }

    public String getPasswordErrorMessage() {
        return syscoLabUIOgm.getText(lblPassword);
    }

    public boolean isInvalidCredentialErrorDisplayed() {
        return syscoLabUIOgm.isDisplayed(lblInvalidCredentials);
    }

    public String getInvalidCredentialErrorMessege() {
        return syscoLabUIOgm.getText(lblInvalidCredentials);
    }

    public String getLoggedInUserName() {
        return syscoLabUIOgm.getText(lnkLoggedInName);
    }

}

package com.sysco.ramith_web.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class LogInPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By lnkLogin = By.xpath("//header/div[1]/div[1]/ul/li[1]");
    private By txtUserName = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnLogin = By.id("send2");
    private By lblErrorUserName = By.id("email-error");
    private By lblPassword = By.id("pass-error");
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

    public boolean isLoginButtonDisplayed() {
        return syscoLabUIOgm.isDisplayed(lnkLogin);
    }

    public void clickOnLoginLink() {
        syscoLabUIOgm.click(lnkLogin);
    }

    public void enterUserName(String userName) {
        syscoLabUIOgm.sendKeys(txtUserName, userName);
    }

    public void enterPassword(String password) {
        syscoLabUIOgm.sendKeys(txtUserName, password);
    }

    public void clickOnLoginButton() {
        syscoLabUIOgm.click(btnLogin);
    }

    public boolean isUserNameErrorMessageDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblErrorUserName);
    }

    public String getUserNameErrorMessageDisplayed(){
        return syscoLabUIOgm.getText(lblErrorUserName);
    }

    public boolean isPasswordErrorMessageDisplayed(){
        return syscoLabUIOgm.isDisplayed(lblPassword);
    }

    public String getPasswordErrorMessageDisplayed(){
        return syscoLabUIOgm.getText(lblPassword);
    }

    public String getLoggedInUserName(){
        return syscoLabUIOgm.getText(lnkLoggedInName);
    }

}

package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.common.Constants;
import com.sysco.ramith_web.pages.LogInPage;
import com.sysco.ramith_web.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class provide functions related to login to the application
 */
public class Login {

    public static LogInPage loginPage = new LogInPage();

    public static void quiteDriver() {
        loginPage.quitDriver();
    }

    public void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            loginPage.loadAthletesPage(capabilities, Constants.APP_URL);
        } else {
            loginPage.loadAthletesPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public boolean isLoginHyperLinkDisplayed() {
        return loginPage.isLoginHyperLinkDisplayed();
    }

    public String logInToApplication(String userName, String password) {
        loginWithGivenCredentials(userName, password);
        return loginPage.getLoggedInUserName();
    }

    public void logInWithOutCredentials() {
        loginWithGivenCredentials("", "");
    }

    public String logInWithInvalidCredentials(String userName, String password) {
        loginWithGivenCredentials(userName, password);
        if (loginPage.isInvalidCredentialErrorDisplayed()) {
            return loginPage.getInvalidCredentialErrorMessege();
        } else {
            return null;
        }
    }

    public String getUserNameErrorMessage() {
        if (loginPage.isUserNameErrorMessageDisplayed()) {
            return loginPage.getUserNameErrorMessage();
        } else {
            return null;
        }
    }

    public String getPasswordErrorMessage() {
        if (loginPage.isPasswordErrorMessageDisplayed()) {
            return loginPage.getPasswordErrorMessage();
        } else {
            return null;
        }
    }

    private void loginWithGivenCredentials(String userName, String password) {
        loginPage.clickOnLoginLink();
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }
}

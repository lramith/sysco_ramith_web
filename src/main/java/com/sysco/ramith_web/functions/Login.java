package com.sysco.ramith_web.functions;

import com.sysco.ramith_web.common.Constants;
import com.sysco.ramith_web.pages.LogInPage;
import com.sysco.ramith_web.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login  {

    public static LogInPage loginPage = new LogInPage();


    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            loginPage.loadAthletesPage(capabilities, Constants.APP_URL);
        } else {
            loginPage.loadAthletesPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public String logInToApplication(String userName, String password) {
        loginWithGivenCredentials(userName, password);
        return loginPage.getLoggedInUserName();
    }

    public void logInWithOutCredentials() {
        loginWithGivenCredentials("", "");
    }

    public void logInWithInvalidCredentials() {
        loginWithGivenCredentials("", "");
    }

    private void loginWithGivenCredentials(String userName, String password){
        loginPage.clickOnLoginLink();
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    public static void quiteDriver() {
        loginPage.quitDriver();
    }
}

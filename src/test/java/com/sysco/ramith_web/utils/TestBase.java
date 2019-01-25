package com.sysco.ramith_web.utils;

import com.sysco.ramith_web.data.LoginData;
import com.sysco.ramith_web.functions.Login;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.annotations.Listeners;

@Listeners(SyscoLabListener.class)
public class TestBase {
    protected Login login;
    protected LoginData loginData;

    protected void initializeLogin() {
        loginData = ExcelUtil.getLoginData("$as2382");
        login = new Login();
        login.loadLoginPage();
    }
}

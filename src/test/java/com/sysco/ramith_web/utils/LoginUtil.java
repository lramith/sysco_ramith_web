package com.sysco.ramith_web.utils;

import com.sysco.ramith_web.functions.Login;

public class LoginUtil extends TestBase {
    protected Login initializeLogin() {
        Login login;
        loginData = ExcelUtil.getLoginData("$as2382");
        login = new Login();
        login.loadLoginPage();
        return login;
    }
}

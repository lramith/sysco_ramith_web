package com.sysco.ramith_web.tests;


import com.sysco.ramith_web.data.LoginData;
import com.sysco.ramith_web.functions.Login;
import com.sysco.ramith_web.utils.ExcelUtil;
import com.sysco.ramith_web.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginToAthletesTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();
        Login.quiteDriver();

    }
}
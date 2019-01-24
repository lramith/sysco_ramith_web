package com.sysco.ramith_web.utils;

import com.sysco.ramith_web.data.LoginData;
import com.sysco.ramith_web.functions.Checkout;
import com.sysco.ramith_web.functions.Login;
import com.sysco.ramith_web.functions.Product;
import com.sysco.ramith_web.functions.Sales;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.sysco.ramith_web.common.Constants;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(SyscoLabListener.class)
public class TestBase {
    protected Login login;
    protected LoginData loginData;

    public void initializeLogin(){
        loginData = ExcelUtil.getLoginData("$as2382");
        login = new Login();
        login.loadLoginPage();
    }
}

package com.sysco.ramith_web.data;

public class LoginData {

    public static String ref;
    public static String userName;
    public static String password;
    public static String invalidUserName;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static String getInvalidUserName() {
        return invalidUserName;
    }
}
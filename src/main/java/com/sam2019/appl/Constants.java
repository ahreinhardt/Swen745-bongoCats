package com.sam2019.appl;

import java.util.HashMap;
import java.util.Map;


public class Constants {

    // URLS
    public static final String HOME_URL = "/home";
    public static final String LOGIN_URL = "/";
    public static final String LOGOUT_URL = "/logout";
    public static final String SIGNUP_URL = "/signup";

    // Session Attributes
    public final static String SESSION_USER = "user";

    // General Page Attributes
    public static final String TITLE_ATTR = "title";

    // Login Page Attributes
    public static final String FAILED_LOGIN_MESSAGE_ATTR = "failedLoginMessage";
    public static final String FAILED_LOGIN_ATTR = "failedLogin";

    //Sign up page attributes

    public static final String FAILED_SIGNUP_MESSAGE_ATTR = "failedSignUpMessage";
    public static final String FAILED_SIGNUP_ATTR = "failedSignUp";

    // Home Page Attributes
    public static final String WELCOME_MESSAGE_ATTR = "welcomeMessage";





    // View Names
    public static final String HOME_VIEW = "home.ftl";
    public static final String LOGIN_VIEW = "login.ftl";
    public static final String SIGNUP_VIEW = "sign.ftl.ftl";

    // Login VM
    public static final Map<String, Object> DEFAULT_LOGIN_VM;

    static {
        DEFAULT_LOGIN_VM = new HashMap<>();
        DEFAULT_LOGIN_VM.put(Constants.TITLE_ATTR, "Login");
        DEFAULT_LOGIN_VM.put(Constants.FAILED_LOGIN_ATTR, false);
        DEFAULT_LOGIN_VM.put(Constants.FAILED_LOGIN_MESSAGE_ATTR, "");
    }

    //Sign Up VM
    public static final Map<String, Object> DEFAULT_SIGNUP_VM;

    static {
        DEFAULT_SIGNUP_VM = new HashMap<>();
        DEFAULT_SIGNUP_VM.put(Constants.TITLE_ATTR, "SignUp");
        DEFAULT_SIGNUP_VM.put(Constants.FAILED_SIGNUP_ATTR, false);
        DEFAULT_SIGNUP_VM.put(Constants.FAILED_SIGNUP_MESSAGE_ATTR, "");
    }

}

package com.selenium.framework.utility;

public class FBConstants {

    /*Locators*/
    public static final String HOMEPAGE_TEXT="//*[@id=\"regForm\"]/h2";
    public static final String HOMEPAGE_FORGOTPASSWORD="//*[@id=\"layout-main\"]/div/div[1]/div/form/a";

    public static final String FORGOTPASSWORD_MAINTEXT="//*[@id=\"reset-password-form\"]/h2";
    public static final String FORGOTPASSWORD_EMAILTEXTBOX = "//*[@id=\"username\"]";
    public static final String FORGOTPASSWORD_FINDACCOUNTBUTTON = "//*[@id=\"reset-password-submit-button\"]";
    public static final String FORGOTPASSWORD_CANCELBUTTON= "//*[@id=\"reset-password-form\"]/div[2]/a";

    public static final String LOGINPAGE_MAINTEXT= "//*[@id=\"app__container\"]/main/div/div[2]/h1";
    public static final String LOGINPAGE_USERNAME= "//*[@id=\"username\"]";
    public static final String LOGINPAGE_PASSWORD= "//*[@id=\"password\"]";
    public static final String LOGINPAGE_SIGNINBUTTON= "//*[@id=\"app__container\"]/main/div/form/div[3]/button";

    public static final String RESETPASSWORDLINK_MAINTEXT = "//*[@id=\"sendemail-form\"]/div[1]/a[1]";
    public static final String RESETPASSWORDLINK_SIGNINBUTTON = "//*[@id=\"app__container\"]/header/div/div/nav/a[1]";

}

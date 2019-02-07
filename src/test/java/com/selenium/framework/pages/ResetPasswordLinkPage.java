package com.selenium.framework.pages;

import com.selenium.framework.utility.FBConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordLinkPage {

    @FindBy(xpath = FBConstants.RESETPASSWORDLINK_MAINTEXT)
    public WebElement mainText;

    @FindBy(xpath = FBConstants.RESETPASSWORDLINK_SIGNINBUTTON)
    public WebElement signin;




}

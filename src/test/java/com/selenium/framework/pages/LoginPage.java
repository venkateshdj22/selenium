package com.selenium.framework.pages;

import com.selenium.framework.utility.FBConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.ws.WebEndpoint;

public class LoginPage {

    @FindBy(xpath = FBConstants.LOGINPAGE_MAINTEXT)
    public WebElement mainText;

    @FindBy(xpath = FBConstants.LOGINPAGE_USERNAME)
    public WebElement username;

    @FindBy(xpath = FBConstants.LOGINPAGE_PASSWORD)
    public WebElement password;

    @FindBy(xpath = FBConstants.LOGINPAGE_SIGNINBUTTON)
    public WebElement signIn;

}

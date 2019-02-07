package com.selenium.framework.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.framework.base.TestBase;
import com.selenium.framework.utility.FBConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends TestBase {

    @FindBy(xpath = FBConstants.HOMEPAGE_TEXT)
    public WebElement homePageText;

    @FindBy(xpath = FBConstants.HOMEPAGE_FORGOTPASSWORD)
    public WebElement forgotPassword;

    public void verifyHomePage(){
        if(homePageText.getText().equals("Be great at what you do")){
            assertSuccess("URL Loaded SuccessFul");
        }else
            assertFailure("ULR Failed To Load");
    }

    public ForgotPasswordPage gotoForgotPasswordPage(){
        test.log(LogStatus.INFO,"Loading Forgot Password Page");
        forgotPassword.click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        if(isElementPresent(FBConstants.FORGOTPASSWORD_EMAILTEXTBOX)){
            assertSuccess("Forgot Password Page Loaded");
            return forgotPasswordPage;
        }else{
            assertFailure("Forgot Password Page Not Loaded");
            return null;
        }
    }

}

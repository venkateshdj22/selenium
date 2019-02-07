package com.selenium.framework.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.framework.base.TestBase;
import com.selenium.framework.utility.FBConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends TestBase {

    @FindBy(xpath = FBConstants.FORGOTPASSWORD_MAINTEXT)
    public WebElement mainText;

    @FindBy(xpath = FBConstants.FORGOTPASSWORD_EMAILTEXTBOX)
    public WebElement emailTextBox;

    @FindBy(xpath = FBConstants.FORGOTPASSWORD_FINDACCOUNTBUTTON)
    public WebElement findAccountButton;

    @FindBy(xpath = FBConstants.FORGOTPASSWORD_CANCELBUTTON)
    public WebElement cancelButton;

    public ForgotPasswordPage(){}

    public void submitEmailAddress(){
        test.log(LogStatus.INFO,"Submitting Email Address to reset Password");
        emailTextBox.sendKeys("venkateshdj22@gmail.com");
        findAccountButton.sendKeys(Keys.ENTER);
        if(isElementPresent(FBConstants.RESETPASSWORDLINK_MAINTEXT)){
            assertSuccess("Resend Password Page Loaded");
        }else
            assertFailure("Resend Password Page Failed to load");
    }

    public void cancelResetPassword(){
        test.log(LogStatus.INFO,"Canceling Reset Password Request");
        emailTextBox.sendKeys("Venkateshdj22@gmail.com");
        cancelButton.click();
        if(isElementPresent(FBConstants.LOGINPAGE_MAINTEXT))
            assertSuccess("Cancel Reset Password Successful");
        else
            assertFailure("Cancel Reset Password Failed");
    }
}

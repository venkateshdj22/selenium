package com.selenium.framework.testCases;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.framework.base.TestBase;
import com.selenium.framework.pages.ForgotPasswordPage;
import com.selenium.framework.pages.HomePage;
import com.selenium.framework.pages.LaunchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ForgotPassword extends TestBase {

    @Test
    public void forgotPasswordTest(){
        test = extent.startTest("Forget Password Test");
        test.log(LogStatus.INFO, "Starting Forget Password test");
        test.log(LogStatus.INFO, "Opening browser");
        LaunchPage launchPage = new LaunchPage();
        PageFactory.initElements(driver,launchPage);
        HomePage homePage = launchPage.goToHomePage();
        PageFactory.initElements(driver,homePage);
        homePage.verifyHomePage();
        ForgotPasswordPage forgotPasswordPage = homePage.gotoForgotPasswordPage();
        PageFactory.initElements(driver,forgotPasswordPage);
        forgotPasswordPage.submitEmailAddress();

    }

    @AfterMethod
    public void quit(){
        if(extent!=null){
            extent.endTest(test);
            extent.flush();
        }
        if(driver!=null)
            driver.quit();
    }

}

package com.selenium.framework.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.framework.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage extends TestBase {

    public HomePage goToHomePage(){
        init();
        openBrowser(prop.getProperty("browser"));
        test.log(LogStatus.INFO, "Opening the url - "+prop.getProperty("url"));
        driver.get(prop.getProperty("url"));
        test.log(LogStatus.PASS, "URL Opened - "+prop.getProperty("url"));
        HomePage homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        return homePage;
    }


}

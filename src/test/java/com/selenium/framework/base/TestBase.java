package com.selenium.framework.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.framework.utility.ExtentManager;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;

    public void init(){
        //init the prop file
        if(prop==null){
            prop=new Properties();
            try {
                FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//projectconfig.properties");
                prop.load(fs);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void openBrowser(String bType){
        test.log(LogStatus.INFO, "Opening browser "+bType );
        if(bType.equals("Mozilla"))
            driver=new FirefoxDriver();
        else if(bType.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+prop.getProperty("chromedriver_exe"));
            driver=new ChromeDriver();
        }
        else if (bType.equals("IE")){
            System.setProperty("webdriver.chrome.driver", prop.getProperty("iedriver_exe"));
            driver= new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser opened successfully "+ bType);
    }

    /*Apps*/

    public boolean isElementPresent(String locator){
        int s = driver.findElements(By.xpath(locator)).size();
        if(s==0){
            test.log(LogStatus.INFO, "Element not found");
            return false;
        }
        else{
            test.log(LogStatus.INFO, "Element found");
            return true;
        }

    }

    public String getText(String locator){
        return driver.findElements(By.xpath(locator)).get(0).getText();
    }

    public void assertFailure(String message){
        test.log(LogStatus.FAIL,message);
        takeScreenShot(message);
        Assert.fail(message);
    }

    public void assertSuccess(String message){
        test.log(LogStatus.PASS,message);
        takeScreenShot(message);
    }

    public void takeScreenShot(String message){
        String screenshotFile=message+".png";
        String filePath=System.getProperty("user.dir")+"//screenshots//"+screenshotFile;
        // store screenshot in that file
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.log(LogStatus.INFO,test.addScreenCapture(filePath));
    }
}

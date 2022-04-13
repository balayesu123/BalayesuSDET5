package com.Practies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.POM_Class.HomePage;
import com.POM_Class.LoginPage;
import com.generic.PropFile_Util;
import com.generic.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiesTest {
    @Test
    public void practiestest() throws Exception
    {
    	PropFile_Util propFile_Util = new PropFile_Util();
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	WebDriverUtils driverUtils = new WebDriverUtils(driver);
		driverUtils.pageloadtimeout();
        driverUtils.maximisewindow();
        
        LoginPage vtiger= new LoginPage(driver);
		driver.get(propFile_Util.readdatafrompropfile("URL"));
		vtiger.logincredentials();
		
		HomePage hp=new HomePage(driver);
		hp.getOrgModule().click();
		hp.logoutfromApp();
    }
}

package com.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.POM_Class.HomePage;
import com.POM_Class.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Fake_Data data= new Fake_Data();
	public WebDriverUtils driverUtils;
	public WebDriver driver;
	public static WebDriver sdriver;
	public HomePage homePage;
	PropFile_Util propFile_Util = new PropFile_Util();

	@BeforeSuite(groups= {"smoke","integration","regression"})
	public void beforesuite() 
	{
		System.out.println("Connection to DB");
	}

	@AfterSuite(groups= {"smoke","integration","regression"})
	public void afterSuite() 
	{
		System.out.println("Dis-Connect from DB");
	}
	// @Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","integration","regression"})
	public void beforeclass() throws IOException
	{
		String BROWSER=propFile_Util.readdatafrompropfile("Browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("ie")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		sdriver=driver;
		driverUtils = new WebDriverUtils(driver);

	}

	@AfterClass(groups= {"smoke","integration","regression"})
	public void afterClass() throws InterruptedException {
		driverUtils.closeBrowser();
	}

	@BeforeMethod(groups= {"smoke","integration","regression"})
	public void logintoVtiger() throws Exception {
		LoginPage loginPage = new LoginPage(driver);

		driverUtils.pageloadtimeout();


		driver.get(propFile_Util.readdatafrompropfile("URL"));

		driverUtils.maximisewindow();

		loginPage.logincredentials();
	}

	@AfterMethod(groups= {"smoke","integration","regression"})
	public void logout() {
		homePage= new HomePage(driver);
		homePage.logoutfromApp();
	}
}

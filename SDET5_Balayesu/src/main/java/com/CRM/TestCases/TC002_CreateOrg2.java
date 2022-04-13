package com.CRM.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.Fake_Data;
import com.generic.PropFile_Util;
import com.generic.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrg2 {


	@Test
	public void createOrg() throws Throwable
	{ 

		//login vtigercrm
		PropFile_Util propFile_Util = new PropFile_Util();
		Fake_Data data= new Fake_Data();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		driverUtils.pageloadtimeout();
		driverUtils.maximisewindow();

		driver.findElement(By.name("user_name")).sendKeys(propFile_Util.readdatafrompropfile("UN"));
		driver.findElement(By.name("user_password")).sendKeys(propFile_Util.readdatafrompropfile("PWD"));
		driver.findElement(By.id("submitButton")).click();

		//Create New Organization with Drop Down

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		String orgName=data.getOrgname();
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		WebElement ele=driver.findElement(By.name("industry"));
		driverUtils.selectValuefromDD(ele, "Chemicals");
		WebElement ele1=driver.findElement(By.name("rating"));
		driverUtils.selectValuefromDD(ele1, "Active");
		WebElement ele2=driver.findElement(By.name("accounttype"));
		driverUtils.selectValuefromDD(ele2, "Customer");
		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);

		//Validation

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		WebElement ele3=driver.findElement(By.id("bas_searchfield"));
		driverUtils.selectValuefromDD(ele3, "accountname");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);

		String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();



		if(actual_orgname.equals(data.getOrgname())) 
		{
			System.out.println("TC Passed");	
		}
		else {
			System.out.println("TC Fail");
		}

		//logout Vtiger application
		driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driverUtils.closeBrowser();
	}
}

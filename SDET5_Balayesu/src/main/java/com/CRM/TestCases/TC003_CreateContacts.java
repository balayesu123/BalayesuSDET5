package com.CRM.TestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.generic.Fake_Data;
import com.generic.PropFile_Util;
import com.generic.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_CreateContacts{
	
  

 @SuppressWarnings("unused")
public static void main(String[] args) throws Throwable {
	
		PropFile_Util propFile_Util = new PropFile_Util();
		Fake_Data data= new Fake_Data();
		
		//Browser launch
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
        driverUtils.pageloadtimeout();
        driverUtils.maximisewindow();
		
        //login Vtiger Appliction
		driver.get(propFile_Util.readdatafrompropfile("URL"));
		driver.findElement(By.name("user_name")).sendKeys(propFile_Util.readdatafrompropfile("UN"));
		driver.findElement(By.name("user_password")).sendKeys(propFile_Util.readdatafrompropfile("PWD"));
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		WebElement ele=driver.findElement(By.name("salutationtype"));
		ele.click();
		driverUtils.selectValuefromDD(ele, "Mr.");

		driver.findElement(By.name("firstname")).sendKeys("Balayesu");
		driver.findElement(By.name("lastname")).sendKeys("Akula");
		driver.findElement(By.cssSelector("img[title='Select']")).click();
		
		//window switching
		String mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String id:allId)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("samsung");
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("1")).click();
		
		driver.switchTo().window(mainId);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//validation

		 driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("Balayesu");
		 
        WebElement ele1=driver.findElement(By.id("bas_searchfield"));
		driverUtils.selectValuefromDD(ele1, "firstname");
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);

		String firstName=driver.findElement(By.xpath("//span[@vtfieldname='firstname']/..")).getText();

		if(firstName.equals("Balayesu")) {
			System.out.println("TC Pass");
		}
		else {
			System.out.println("TC Fail");
		}
		
		//logout Vtiger application
		driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
}
}

package com.Practies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Hard_Soft_AssertTest {
   @Test
   public void  hard_Soft_AssertTest() throws Exception
   {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://localhost:8888");
	   String title = driver.getTitle();
	   //Assert.assertEquals(title, "vtiger CRM 5 - Commercial Open Source CRM");
	     SoftAssert softAssert = new SoftAssert();
	     softAssert.assertEquals(title, "vtiger");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("1234");
		driver.findElement(By.id("submitButton")).click();
		softAssert.assertAll();
   }
}

package com.Practies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listeners_Execution1.class)
public class ListenersAnnotationTest  {

	public WebDriver driver;
	public static WebDriver sdriver;
	@Test
	public void listenersAnnotationTest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sdriver=driver;
		driver.get("http://localhost:8888"); 
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("1234");
		driver.findElement(By.id("submitButton")).click();
		Assert.assertEquals(true, false);

	}
}

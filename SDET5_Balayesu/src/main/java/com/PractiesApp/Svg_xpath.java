package com.PractiesApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Svg_xpath {
  
	@Test
	public void noon() throws Exception
	{
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.learnatnoon.com/");
	    driver.findElement(By.cssSelector("svg[class='icon icon-noon pointer']")).click();
	    driver.findElement(By.xpath("//*[name()='svg' and @class='icon icon-noon pointer']")).click();
		
		driver.get("https://www.icc-cricket.com/");
	    driver.findElement(By.xpath("//div[normalize-space()='Live']")).click();*/
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("poco c31");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='POCO C31 (Royal Blue, 64 GB)']/../../../div/div[2]/div/label/span")).click();
	}
}

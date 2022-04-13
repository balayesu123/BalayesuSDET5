package com.PractiesApp;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipcart_AddtoCart {
  @Test
  public void addToCart() throws Throwable
  {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		String price=driver.findElement(By.xpath("//div[text()='APPLE iPhone SE (Red, 128 GB)']/../../div[2]/div/div/div")).getText();
		 System.out.println(price);
		driver.findElement(By.xpath("//div[text()='APPLE iPhone SE (Red, 128 GB)']")).click();
		String mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String id:allId)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1000);");
		driver.findElement(By.xpath("(//button[@class='_23FHuj'])[2]")).click();
		Thread.sleep(3000);
		String totalPrice=driver.findElement(By.xpath("//span[text()='55,998']")).getText();
		System.out.println(totalPrice);
  }
}

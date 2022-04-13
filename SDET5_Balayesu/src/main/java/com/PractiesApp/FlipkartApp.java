package com.PractiesApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartApp {
  @Test
  
  public void flipkart() throws Throwable
  {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("mobiles under 20000");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,100);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='_24_Dny'])[5]")).click();
		Thread.sleep(3000);
		String text=driver.findElement(By.xpath("//div[text()='Redmi Note 11 (Horizon Blue, 64 GB)']")).getText();
		if(text.contains("Redmi"))
		{
			System.out.println("TC Passed");
		}
		else
		{
			System.out.println("TC Fail");
		}
		Thread.sleep(3000);
		String price=driver.findElement(By.xpath("//div[text()='Redmi Note 11 (Horizon Blue, 64 GB)']/../../div[2]/div/div/div")).getText();
		   String newPrice=price.replace(",", "");
		   String newPrice2=newPrice.replace("₹", "");
		   int chPrice=Integer.parseInt(newPrice2);
		   if(chPrice<20000)
		   {
			   System.out.println(chPrice+ " TC Passed");
		   }
		   else
			{
				System.out.println(chPrice+" TC Fail");
			}
		
  }
}

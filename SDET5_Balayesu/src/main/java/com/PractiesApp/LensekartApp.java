package com.PractiesApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LensekartApp {
  @Test
  public void lensekart() throws Exception
  {
	  //search-icon
	  WebDriverManager.chromedriver().setup();
	 	WebDriver driver =new ChromeDriver();
	 	driver.manage().window().maximize();
	 	driver.get("https://www.lenskart.com/");
	 	driver.findElement(By.name("q")).click();
	 	Thread.sleep(3000);
	 	List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
	 	for(WebElement i : ele)
	 	{
	 		String s=i.getText();
	 		System.out.println(s);
	 	}
	 	
  }
}

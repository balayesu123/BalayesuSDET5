package com.CRM.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetPricesUnder5000inFlipcart {
  public static void main(String[] args) throws Throwable {
	  WebDriverManager.chromedriver().setup();
	 	WebDriver driver =new ChromeDriver();
	 	driver.manage().window().maximize();
	 	driver.get("https://www.flipkart.com/");
	 	driver.findElement(By.xpath("//button[text()='✕']")).click();
	 	WebElement ele = driver.findElement(By.name("q"));
	 	ele.sendKeys("mobiles Under 5000");
	 	ele.submit();
	 	Thread.sleep(3000);
	 	List<WebElement> ele1=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	 	for(WebElement i:ele1)
	 	{
	 		String s=i.getText();//₹
	 		String newprice = s.replace(",", "");
	 		String newprice2 = newprice.replace("₹", "");
	 		int finalprice=Integer.parseInt(newprice2);
	 		System.out.println(finalprice+250);
	 	}	
  }
}

package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLess_HtmlUnitDriver {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		HtmlUnitDriver driver=new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.flipkart.com/");
		
		System.out.println(driver.getTitle());
		
//	     driver.findElement(By.xpath("//button[text()='✕']")).click();
//	     System.out.println("click on popup");
//		driver.findElement(By.name("q")).sendKeys("mobiles under 20000");
//		System.out.println("enter mobiles under 20000");
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		 System.out.println("click for search");

	}

}

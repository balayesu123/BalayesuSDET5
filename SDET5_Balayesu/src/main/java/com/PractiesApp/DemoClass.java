package com.PractiesApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
    
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
	  List<WebElement> languag = driver.findElements(By.xpath("//div[text()='Google offered in:  ']/a"));
	  
	  for(WebElement ele : languag)
	  {
		 String lg = ele.getText();
		 System.out.println(lg);
	  }
		  
	 


	}
}
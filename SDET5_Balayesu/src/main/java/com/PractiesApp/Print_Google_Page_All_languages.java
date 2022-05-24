package com.PractiesApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Print_Google_Page_All_languages {
   public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	  List<WebElement> languages = driver.findElements(By.xpath("//div[text()='Google offered in:  ']/a"));
	  
	  for(WebElement lg:languages)
	  {
		  String lang = lg.getText();
		  System.out.println(lang);
	  }
}
}

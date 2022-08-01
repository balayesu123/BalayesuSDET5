package com.PractiesApp;

import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_First_Char {
   public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.com/");
	List<WebElement> dropdown = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
	for(int i=0 ; i<dropdown.size() ; i++)
	{
	      String tex = dropdown.get(i).getText();
	     char ch = tex.charAt(0);
	     if(ch=='B') 
	     {
	    	 System.out.println(tex);
	    	 dropdown.get(i).click();
	     }
	     
	}
	
	
     
}
}

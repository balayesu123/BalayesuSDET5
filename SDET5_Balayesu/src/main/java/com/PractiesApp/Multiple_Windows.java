package com.PractiesApp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Windows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("mobiles under 15000");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		 driver.findElement(By.xpath("//div[text()='POCO C31 (Royal Blue, 64 GB)']")).click();
		 driver.findElement(By.xpath("//div[text()='realme Narzo 50 (Speed Blue, 64 GB)']")).click();
		 driver.findElement(By.xpath("//div[text()='IAIR D40']")).click();
		 
		 Set<String> windowId = driver.getWindowHandles();
		 
		 for (String id : windowId)
		    {
				String title=driver.switchTo().window(id).getTitle();
				if(title.contains("IAIR D40 ( 32 GB Storage, 32 GB RAM ) Online at Best Price On Flipkart.com"))
				{
					driver.close();
					break;
				}
			}
		 
		 //***********2nd Approach**************
	
	/*	String parent_window = driver.getWindowHandle();
		Set<String> all_windows = driver.getWindowHandles();
		
		for(String window : all_windows)
		{
			if(!parent_window.equals(window))
			{
				driver.switchTo().window(window);
			}
		}      */
		
		//***********3rd Approach**************
		 
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));
		
		//***********4th Approach**************
		 
		 
   /*    Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator = windowId.iterator();

		while(iterator.hasNext()) 
		{
			String currentwindow=iterator.next();
			String currenttitle=driver.switchTo().window(currentwindow).getTitle();
			
			if(currenttitle.contains("Cab Booking - Outstation cabs, Car Rental, Taxi & Cars Booking")) {
				
				System.out.println(currenttitle);
				break;
			}
		}       */
		
		
	}

}

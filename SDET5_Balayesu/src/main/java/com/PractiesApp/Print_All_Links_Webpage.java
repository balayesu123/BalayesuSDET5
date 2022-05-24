package com.PractiesApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Print_All_Links_Webpage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));		
		for (int i = 0; i <links.size(); i++) 
		{
			System.out.println(links.get(i).getAttribute("href"));
			//System.out.println(links.get(i).getText());
//			char h=linkname.charAt(0);
//			System.out.println(h);
//			if(h=='a') {
//				System.out.println(linkname);
//			}
//
		}



		

	}

}

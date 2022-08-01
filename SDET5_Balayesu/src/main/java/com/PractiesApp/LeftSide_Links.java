package com.PractiesApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeftSide_Links {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.onlinegdb.com/online_java_compiler");
		//List<WebElement> links = driver.findElements(By.xpath("//div[@id='left-component']//child::a"));
		List<WebElement> links = driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked text-center']//child::a"));
		for (WebElement leftsidelinks : links) 
		{
			String str = leftsidelinks.getAttribute("href");
			System.out.println(str);
		}

	}

}

package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://books-pwakit.appspot.com/");

                 //***********1st Approach************
		
		//This Element is inside single shadow DOM.
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		shadow.findElement(By.cssSelector("#input")).sendKeys("maths");

		         //***********2nd Approach************
		
		//		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//		WebElement shadowdom = (WebElement)jse.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
		//		shadowdom.sendKeys("maths");

	}

}

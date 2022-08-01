package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_Resource {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	      String url = "https://www.tutorialspoint.com/index.htm";
	      driver.get(url);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      // identify image
	      WebElement l =driver.findElement(By.xpath("//img[@alt='logo']"));
	      //getAttribute() to get src of image
	      System.out.println("Src attribute is: "+ l.getAttribute("src"));
	      driver.quit();

	}

}

package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_Files {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		driver.switchTo().frame("aswift_3");
		driver.switchTo().frame("ad_iframe");
		driver.findElement(By.xpath("//span[text()='Close']")).click();
			
		
		
	}

}

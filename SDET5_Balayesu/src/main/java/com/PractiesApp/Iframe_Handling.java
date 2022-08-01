package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe_Handling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

		// 1 st frame
		driver.switchTo().frame("packageListFrame"); // 'name' of the frame or we can write 'id' of the frame 
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent();  // this statement is used for go back to the main page


		// 2 nd frame
		driver.switchTo().frame("packageFrame"); // 'name' of the frame or we can write 'id' of the frame 
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent();  // this statement is used for go back to the main page

		// 3 rd frame
		driver.switchTo().frame("classFrame"); // 'name' of the frame or we can write 'id' of the frame 
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();


	}

}

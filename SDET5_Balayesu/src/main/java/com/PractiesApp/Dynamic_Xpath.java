package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Xpath {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("realme 9 5G (Meteor Black, 128 GB)  (6 GB RAM)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Absolute X-path
		
		//String text=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div/div/div")).getText();
		
		// Relative X-path
		
		//String text=driver.findElement(By.xpath("//div[text()='realme 9 5G (Meteor Black, 128 GB)']/../../div[2]/div/div/div")).getText();
		
		//String text=driver.findElement(By.xpath("//div[text()='realme 9 5G (Meteor Black, 128 GB)']/parent::div/following-sibling::div/div/div/div")).getText();
		
		//String text=driver.findElement(By.xpath("//div[text()='realme 9 5G (Meteor Black, 128 GB)']/ancestor::div[2]/div[2]/div/div/div")).getText();
		
		//String text=driver.findElement(By.xpath("//div[text()='realme 9 5G (Meteor Black, 128 GB)']/../../descendant::div[9]")).getText();
		
		//String text=driver.findElement(By.xpath("//div[text()='realme 9 5G (Meteor Black, 128 GB)']/following::div[7]")).getText();
		
		String text=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
		System.out.println(text);
		
		
	}

}

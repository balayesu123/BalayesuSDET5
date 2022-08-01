package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript_Alert_Popup {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
		
	    driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert alt = driver.switchTo().alert();
		Thread.sleep(4000);
		//alt.sendKeys("Balayesu");
		System.out.println(alt.getText());
		alt.accept();
		
		

	}

}

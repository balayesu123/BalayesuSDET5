package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipTool {

 public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.w3schools.com/css/css_tooltip.asp#:~:text=A%20tooltip%20is%20often%20used,Bottom");
	String toolTip = driver.findElement(By.xpath("//a[text()='JAVASCRIPT']")).getAttribute("title");
	System.out.println(toolTip);
}
 
}

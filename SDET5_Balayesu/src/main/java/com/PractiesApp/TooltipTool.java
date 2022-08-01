package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipTool {

 public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.w3schools.com/css/css_tooltip.asp#:~:text=A%20tooltip%20is%20often%20used,Bottom");
//	String toolTip = driver.findElement(By.xpath("//a[text()='JAVASCRIPT']")).getAttribute("title");
//	System.out.println(toolTip);
	
	
	//**************2nd method***************** 
	
	driver.get("https://demoqa.com/tool-tips");
	WebElement hoverButton = driver.findElement(By.id("toolTipButton"));
	Actions act = new Actions(driver);
	act.moveToElement(hoverButton).perform();
	String text=driver.findElement(By.xpath("//*[text()='You hovered over the Button']")).getText();
	System.out.println(text);
 }
}

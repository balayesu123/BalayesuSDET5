package com.PractiesApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
  @Test
  public void hoverMessage()
  {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		WebElement text = driver.findElement(By.xpath("//img[@title='Create Organization...']"));
		String s = text.getAttribute("title");
		System.out.println(s);
  }
}

package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementException {
	/* @Test
  public void staleElement()
  { 

	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement login = driver.findElement(By.id("submitButton"));
		username.sendKeys("admin");
		driver.navigate().refresh();
		password.sendKeys("admin");
		login.click();


  }*/

	WebDriver driver=new ChromeDriver();
	
	@FindBy(name="user_name")
	WebElement username;
	
//	@FindBy(name="user_password")
//	WebElement password;

//	@FindBy(id="submitButton")
//	WebElement login;
	
	// goes with AND conditoin
	
//	@FindBys(value = {@FindBy(name="user_name"),@FindBy(xpath="//input[@name='user_name']")})
//	WebElement username;
//	
	@FindBys(value = {@FindBy(name="user_password"),@FindBy(xpath="//input[@name='user_password']")})
	WebElement password;
//	
//	@FindBys(value = {@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
//	WebElement login;
	
	// goes with OR conditoin
	
	@FindAll(value = {@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	WebElement login;
	
	public StaleElementException()
	{
		PageFactory.initElements(driver,this);
	}

	@Test
	public void test()
	{  
		
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		username.sendKeys("admin");
	    driver.navigate().refresh();
		password.sendKeys("admin");
		login.click();
	}

}

package com.PractiesApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hidden_Dropdown_Suggestions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		//driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		// when you searching or click on Drop down it will give multiple suggestions 
		// if you want to print all suggestions we need to inspect the drop down
		// while inspecting drop down some times it will disappear so to handle this type of drop down
		// First go to DOM Structure click on Event Listener move to blur option and click on it 
		// it will give some suggestions,remove it and again click on drop down and click on DOM arrow then inspect 
		
		driver.findElement(By.name("q")).sendKeys("macbook");
		List<WebElement> allSuggestions = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li"));
		
		for (WebElement suggestion : allSuggestions) 
		{
			System.out.println(suggestion.getText());
		}

	}

}

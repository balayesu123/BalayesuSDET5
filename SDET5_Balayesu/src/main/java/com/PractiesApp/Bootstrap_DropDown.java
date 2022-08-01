package com.PractiesApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_DropDown {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_3"); 
		driver.findElement(By.className("caret")).click();
		// this xpath can print all the options
		//List<WebElement> list = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li"));
		
		//this xpath can print only specified options 
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu')]/li[not(@class=\"multiselect-item multiselect-group\")]"));
		System.out.println("total count of dropdown : "+list.size());
		
		for (WebElement ele : list) {
			
			String s=ele.getText();
			System.out.println(s);
		}

	}

}

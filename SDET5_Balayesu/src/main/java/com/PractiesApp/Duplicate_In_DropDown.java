package com.PractiesApp;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicate_In_DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("searchDropdownBox")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
		boolean flag=false;
		for (int i = 0 ; i < ele.size(); i++) 
		{
			String text1 = ele.get(i).getText();
			for(int j = i+1 ; j < ele.size(); j++)
			{
				String text2 = ele.get(j).getText();
				if(text1.equals(text2))
				{
					System.out.print(text2+" ");
					flag=true;
				}		
			}   
		}
		if(flag==false)
		{
			System.out.println("No Duplicate");
		}
	}

}

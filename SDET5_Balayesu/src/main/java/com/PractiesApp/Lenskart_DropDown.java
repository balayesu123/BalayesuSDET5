package com.PractiesApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart_DropDown {
  @Test
  public void lenskart()
  {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.name("q")).click();
		 List<WebElement> ele = driver.findElements(By.xpath("//div[@class='trending_block']/ul/li"));
		 for(int i=1 ; i <  ele.size() ; i++)
			{
				String option=ele.get(i).getText();
				char ch=option.charAt(option.length()-1);
				
				if(ch=='y')
				{
					System.out.println(option);
					ele.get(i).click();
					break;
				}
			}
  }
}

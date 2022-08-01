package com.PractiesApp;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		driver.get("https://www.hyrtutorials.com/#");
//		WebElement lang = driver.findElement(By.xpath("//a[text()='Selenium Practice']"));  
//		Actions act =new Actions(driver);
//		act.moveToElement(lang).perform();
//		List<WebElement> opt = driver.findElements(By.xpath("//a[text()='Selenium Practice']/../ul/li"));  
//		for(WebElement options : opt)
//		{
//			String str=options.getText(); 
//			System.out.println(str);
//		}
		
		// ************** ADD to CART***********
            
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13 max pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Apple iPhone 13 Pro Max (256GB) - Sierra Blue']")).click();
		String mainId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();  
		
		for(String id : allIds)
		{
			if(!mainId.equals(allIds))
			{
				driver.switchTo().window(id);
			}
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000);");
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		
	}

}

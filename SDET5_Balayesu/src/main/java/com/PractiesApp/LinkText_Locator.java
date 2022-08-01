package com.PractiesApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkText_Locator {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");

		// By using inner text i.e (Today's Deals) in linkText() locator it find the link of that text

		WebElement ele = driver.findElement(By.linkText("Today's Deals"));
		String innerText = ele.getText();
		System.out.println(innerText);
		String link = ele.getAttribute("href");
		System.out.println(link);
		ele.click();

		//  driver.findElement(By.partialLinkText("Deals")).click(); 

		// ***** find All Links in web page*******

		/* List<WebElement> links = driver.findElements(By.tagName("a"));
      System.out.println(links.size());
      for(WebElement allLinks : links)
      {
    	 System.out.println(allLinks.getText());
    	 System.err.println(allLinks.getAttribute("href"));
      }  */

	}

}

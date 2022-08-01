package com.PractiesApp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");

		int brokenlinks = 0 ;

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for(WebElement link : allLinks )
		{
			String url = link.getAttribute("href");

			if(url == null || url.isEmpty())
			{
				System.out.println("link is null");
				continue ;
			}
			try {
				URL links = new URL(url);
				HttpURLConnection httpconn = (HttpURLConnection)links.openConnection();
				httpconn.connect();

				if(httpconn.getResponseCode() >= 400)
				{
					System.err.println(" The Status Code is " + httpconn.getResponseCode() + " it is a Broken link " + url);
					brokenlinks++;
				}
				else
				{
					System.out.println(" The Status Code is " + httpconn.getResponseCode() + " it is a valid link " + url);
				}

			}
			catch (Exception e) {

			}
		}
		System.out.println("Number of Broken Links are : "+brokenlinks);
		driver.quit();

	}

}

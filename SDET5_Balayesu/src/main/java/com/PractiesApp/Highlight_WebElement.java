package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Highlight_WebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		// using javascript find the element and hilight the border and backgroung
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('email').style.border='2px solid red';");
		//jse.executeScript("document.getElementById('email').style.background='yellow';");
		//jse.executeScript("document.getElementById('email').setAttribute('style', 'border:2px solid red; background:yellow');");

		// first find the element using findelement method then highlight the border and background color using 
		//javascript
		
		  //WebElement ele = driver.findElement(By.id("email"));
		//jse.executeScript("arguments[0].style.border='2px solid red';",ele);
		//jse.executeScript("arguments[0].style.background='yellow';",ele);
		//jse.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow');",ele);

	}

}

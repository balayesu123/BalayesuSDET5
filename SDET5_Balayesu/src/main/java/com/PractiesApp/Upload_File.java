package com.PractiesApp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_File {

	public static void main(String[] args) throws AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.monsterindia.com/");
		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();

		//********** Uploading file using sendKeys() method***********

		// sendKeys() method will works only, when the "type" attribute is present  in html DOM.
		// If "type" attribute is not present SendKeys() method won't work,we should use Robot class

		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("G:\\SDET-5-HYD\\Sample Resume\\Single-Page-Resume.pdf");

		//************* Uploading file using Robot Class*************

	/*	//driver.findElement(By.xpath("//input[@id='file-upload']")).click();
		//If normal click action not work it will throw InvalidArgumentException,then  go with JavascriptExecutor
        
		WebElement upl = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", upl);  // click action on file upload button

		Robot r = new Robot();
		r.delay(2000);
		
		// copy the path and put the path of the file in to a clipboard
		StringSelection ss = new StringSelection("G:\\SDET-5-HYD\\Sample Resume\\Single-Page-Resume.pdf");
		// this reference 'ss' variable is pointing to the given path of the file
		// The Toolkit class methods  put the path of the file in to a Clipboard 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl+V
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		 
		// Enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);   */

	}

}

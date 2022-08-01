package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Enter_Text_Using_JavaScripExecutor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");

		// Enter text using javascriptExecutor

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('txtUsername').value='Admin'");
		js.executeScript("document.getElementsByName('txtPassword')[0].value='admin123'");

		// perform click operation using javascriptExecutor

		js.executeScript("document.getElementsByClassName('button')[0].click();");

	}

}

package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authenticated_Popup {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		// when you are open the above url it will give Authenticated_Popup.
		// To handle the Authenticated_Popup we need to pass proper credentials like username and password
		// here we can not pass the user name and password directly we need to follow the syntax
		// Syntax ---->  https://username:password@URL
		// Here instead passing the direct URL we need to add username and password into the URL like syntax mentioned the above
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}

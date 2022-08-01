package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Find_the_color_Of_Element {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
        
		// getCssValue("parameter") method gives the code of rgba(red, green, blue, alpha)
		
		String expected_hexcode="#1877f2";
		String rgba_ColorCode = driver.findElement(By.name("login")).getCssValue("background-color");
		System.out.println(rgba_ColorCode); // output = rgba(24, 119, 242, 1)
		
		// To convert rgba to hex (hexadecimal) we need to use method
		
		String hexdecimal_ColorCode = Color.fromString(rgba_ColorCode).asHex();
		System.out.println(hexdecimal_ColorCode);
		
		if(expected_hexcode.equals(hexdecimal_ColorCode))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		
	//	String buttonColor = driver.findElement(By.xpath("//a[text()='Create New Account']")).getCssValue("background-color");
	//	System.out.println(buttonColor);
	}
	

}

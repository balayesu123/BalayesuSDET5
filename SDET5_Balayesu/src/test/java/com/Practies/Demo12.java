package com.Practies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo12 {

	public static void main(String[] args) throws InterruptedException {

		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver=new ChromeDriver();
		//		driver.manage().window().maximize();
		//		
		//		Demo demo = new Demo();
		//		demo.flipkart(driver);


		String str="qwerty";

		Demo d = new Demo();
		String s=d.rev(str);
		System.out.println(s);
	}

}

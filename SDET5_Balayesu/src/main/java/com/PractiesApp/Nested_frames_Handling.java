package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_frames_Handling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/nestedframes");
		
		// this is used to switchTo the parent frame to inside another chiled frame
		driver.switchTo().frame("frame1").switchTo().frame(0); 
		String childFrameText = driver.findElement(By.tagName("p")).getText();
		System.out.println(childFrameText);
		
		// which is used to switch back to the parent Frame
		driver.switchTo().parentFrame();
		String parentFrameText = driver.findElement(By.xpath("//body[text()='Parent frame']")).getText();
		System.out.println(parentFrameText);
		
		// this is used to back to main page i.e document page
		driver.switchTo().defaultContent();
		String mainPage = driver.findElement(By.xpath("//div[text()='Nested Frames']")).getText();
		System.out.println(mainPage);
		

	}

}

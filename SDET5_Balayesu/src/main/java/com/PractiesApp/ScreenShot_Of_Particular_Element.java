package com.PractiesApp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot_Of_Particular_Element {

	public static void main(String[] args) throws Exception {
		
		 //set the location of chrome browser
        WebDriverManager.chromedriver().setup();
        
        // Initialize browser
        WebDriver driver = new ChromeDriver();
        
        //navigate to url
        driver.get("https://demoqa.com");
        
        // Locate the web element
        WebElement logo = driver.findElement(By.xpath("//*[@id='app']/header/a/img"));
        
        // capture screenshot with getScreenshotAs() of the WebElement class
        File f = logo.getScreenshotAs(OutputType.FILE);
        
        FileUtils.copyFile(f, new File("./screenshot/ToolsQAlogo.png"));
        
        driver.close();

	}

}

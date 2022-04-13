package com.PractiesApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HdfcBank {
    @Test
    public void hdfc()
    {
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.manage().window().maximize();
    	driver.get("https://www.hdfcbank.com/");
    	//Alert alt = driver.switchTo().alert();
    	//alt.dismiss();
    	driver.findElement(By.cssSelector("g[stroke='none']")).click();
    	driver.findElement(By.className("closeSummer")).click();
    	driver.findElement(By.xpath("//a[text()='Select Product Type']")).click();
    	driver.findElement(By.xpath("//li[text()='Deposits']")).click();
    	
    }
}

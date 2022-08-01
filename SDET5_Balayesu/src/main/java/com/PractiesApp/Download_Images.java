package com.PractiesApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_Images {

	public static void main(String[] args) throws Exception {
		/*
		   1) visit web page (driver.get("www.coolithelp.com").
           2) find all img tags on-page.
           3) and then fetch src links in a list.
           4) traverse list and pick src one by one and download images and save on disk.
           Here we are using ImageIO.read() to read image and ImageIO.write() to write image on disk.
		*/
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       
      // driver.get("https://www.pexels.com/search/desktop%20wallpaper/");
      // String imageURL = driver.findElement(By.xpath("//div[@class='BreakpointGrid_grid__xedYm BreakpointGrid_grid-tablet__K6hfA']//img[@alt='Free Gray and Black Galaxy Wallpaper Stock Photo']")).getAttribute("src");
       
       driver.get("https://www.coolithelp.com/");
       String imageURL = driver.findElement(By.xpath("//div[@id='post-body-5759694562990493708']//img")).getAttribute("src");
       // converting string URL into Real URL
       URL realImgURL = new URL(imageURL);
       
       // Read image from given web URL
       BufferedImage saveImage = ImageIO.read(realImgURL);
       
       // write the image on disk
       ImageIO.write(saveImage, "jpg", new File("wallpaper.jpg"));
       
       
       
	}

}

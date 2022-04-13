package com.PractiesApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Compare_Two_ProductPrices {
   @Test
   public void comparePrice() throws Throwable
   {
	   // Compare Redmi Note 11 (Horizon Blue, 64 GB) Price
	   WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Redmi Note 11 (Horizon Blue, 64 GB)");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		String flipkart=driver.findElement(By.xpath("//div[text()='Redmi Note 11 (Horizon Blue, 64 GB)']/../../div[2]/div/div/div")).getText();
		String newPrice=flipkart.replace(",", "");
		   String flipkartPc=newPrice.replace("₹", "");
		   int flipkartPrice=Integer.parseInt(flipkartPc);
       // driver.close();
        
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi Note 11 (Horizon Blue, 64 GB)");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);
        String amazon=driver.findElement(By.xpath("//span[contains(text(),'Redmi Note 11 (Horizon Blue, 6GB RAM, 64GB')]/../../../../div[3]/div/div/div/div/a/span/span[2]/span[2]")).getText();
        String newPrice1=amazon.replace(",", "");
		   String amazonPc=newPrice1.replace("₹", "");
		   int amazonPrice=Integer.parseInt(amazonPc);
		  if(flipkartPrice>amazonPrice)
		  {
			  System.out.println("flipkartPrice = "+flipkartPrice +" is Greater than "+"AmazonPrice = "+amazonPrice);
		  }
		  else if(flipkartPrice<amazonPrice)
		  {
			  System.out.println("flipkartPrice = "+flipkartPrice +" is Less than "+"AmazonPrice = "+amazonPrice);
		  }
		  else
		  {
			  System.out.println("flipkartPrice = "+flipkartPrice + "is Equels To "+"AmazonPrice = "+amazonPrice);
		  }
			  
   }
}

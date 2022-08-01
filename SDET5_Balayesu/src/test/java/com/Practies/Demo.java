package com.Practies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {


	public void  flipkart(WebDriver driver) throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement searchbocelement = driver.findElement(By.name("q"));
		searchbocelement.sendKeys("Redmi Note 11 (Horizon Blue, 64 GB)");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		String flipkart=driver.findElement(By.xpath("//div[text()='Redmi Note 11 (Horizon Blue, 64 GB)']/../../div[2]/div/div/div")).getText();
		String newPrice=flipkart.replace(",", "");
		String flipkartPc=newPrice.replace("₹", "");
		int flipkartPrice=Integer.parseInt(flipkartPc);
		System.out.println(flipkartPrice);
	}

	public String rev(String str) {
		char[] ch=str.toCharArray();
		String reverse="";
		
		for (int i = ch.length-1; i >= 0; i--)
		{
			reverse=reverse+ch[i];
		}
		return reverse;
	}

	//public static void main(String[] args) {

	//		WebDriverManager.chromedriver().setup();
	//		WebDriver driver= new ChromeDriver();
	//
	//
	//		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
	//
	//
	//
	//		//String	text=driver.findElements(By.xpath("//table[@id='contactList']//tr/td[2]")).getText();
	//
	//		///	System.out.print(text);
	//
	//
	//
	//		List<WebElement> text = driver.findElements(By.xpath("//table[@id='contactList']//tr/td[2]"));
	//
	//		for(int j=0; j<=text.size();j++) {
	//			String name	= text.get(j).getText();
	//			System.out.print(name +" ");
	//			//int temp=j+2;
	//			//	String sal=	driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td["+temp+"]")).getText();
	//			String sal	=driver.findElement(By.xpath("//table[@id='contactList']//tr["+(j+2)+"]/td[4]")).getText();
	//
	//			System.out.println(sal);
	//
	//		}
	//



}



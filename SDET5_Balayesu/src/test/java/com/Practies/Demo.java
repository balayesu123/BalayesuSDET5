package com.Practies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();


		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");



		//String	text=driver.findElements(By.xpath("//table[@id='contactList']//tr/td[2]")).getText();

		///	System.out.print(text);



		List<WebElement> text = driver.findElements(By.xpath("//table[@id='contactList']//tr/td[2]"));

		for(int j=0; j<=text.size();j++) {
			String name	= text.get(j).getText();
			System.out.print(name +" ");
			//int temp=j+2;
			//	String sal=	driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td["+temp+"]")).getText();
			String sal	=driver.findElement(By.xpath("//table[@id='contactList']//tr["+(j+2)+"]/td[4]")).getText();

			System.out.println(sal);

		}




	}

}

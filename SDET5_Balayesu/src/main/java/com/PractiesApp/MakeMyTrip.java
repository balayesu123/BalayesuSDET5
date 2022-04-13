package com.PractiesApp;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	@Test(dataProvider = "multipleData")
	public void multipledestination(String src,String dest) throws Exception
	{

		Date date=new Date();
		String s1=date.toString();
		System.out.println(s1);

		// Tue Apr 05 13:14:21 IST 2022
		//  0   1   2    3      4   5

		String[] str = s1.split(" ");
		String date1=str[2];
		String day=str[0];
		String month= str[1];
		String year=str[5];
		String currentdate=day+" "+month+" "+date1+" "+year;
		System.out.println(currentdate);

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//div[@data-cy='outsideModal']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		//String src="PNQ";
		//String dest="DEL";
		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();
		driver.findElement(By.id("toCity")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();
		//driver.findElement(By.xpath("//div[@aria-label=\"Tue Apr 05 2022\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label=\'"+currentdate+"']")).click();

	}
	@DataProvider
	public Object[][] multipleData()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="HYD";
		obj[0][1]="CCU";

		obj[1][0]="PNQ";
		obj[1][1]="DEL";


		return obj;
	}
}

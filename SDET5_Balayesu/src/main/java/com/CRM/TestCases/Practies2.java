package com.CRM.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practies2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Throwable {
		FileInputStream fil=new FileInputStream("./SDET_DataDrivenFile.properties");
		Properties p=new Properties();
		p.load(fil);
		String url = p.getProperty("URL");
		String un = p.getProperty("UN");
		String pwd = p.getProperty("PWD");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//login Vtiger Appliction
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd,Keys.ENTER);

		//create organization name
		Random r=new Random();
		int x=r.nextInt(1000);

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		File file=new File("./DataVtiger.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		String cellvalue00=sheet.getRow(0).getCell(0).getStringCellValue();
		driver.findElement(By.name("accountname")).sendKeys(cellvalue00+x);
		WebElement ele=driver.findElement(By.name("industry"));
		ele.click();
		ele.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER,Keys.TAB,Keys.ENTER,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER,Keys.TAB,Keys.ENTER,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.name("button")).click();

		//search for  organisationName
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.className("txtBox")).sendKeys(cellvalue00+x);
		Thread.sleep(3000);
		WebElement ele1=driver.findElement(By.id("bas_searchfield"));
		ele1.click();
		Select s=new Select(ele1);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();

		//logout Vtiger application
		driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}

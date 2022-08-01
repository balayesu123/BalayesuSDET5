package com.CRM.TestCases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practies1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		//System.setProperty("webdriver.chrome.driver","G:\\seleniumDrivers\\chromedriver.exe");

		FileInputStream fil=new FileInputStream("./SDET_DataDrivenFile.properties");
		Properties p=new Properties();
		p.load(fil);
		String url = p.getProperty("URL");
		String un = p.getProperty("UN");
		String pwd = p.getProperty("PWD");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//login Vtiger Appliction
		driver.get(url);

		//create organization name
		//		Random r=new Random();
		//		int x=r.nextInt(1000);
		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		//		File file=new File("./DataVtiger.xlsx");
		//		FileInputStream fis=new FileInputStream(file);
		//		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		//		XSSFSheet sheet=workbook.getSheetAt(0);
		//		String cellvalue00=sheet.getRow(0).getCell(0).getStringCellValue();
		driver.findElement(By.name("accountname")).sendKeys("abc1");
		driver.findElement(By.name("button")).click();

		//(validation) search for an organisationName 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.className("txtBox")).sendKeys("abc1");
		WebElement ele=driver.findElement(By.id("bas_searchfield"));
		ele.click();
		Select s=new Select(ele);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();

		String actul_orgName= driver.findElement(By.cssSelector("a[title='Organizations']")).getText();
		if(actul_orgName.equals("abc1"))
		{
			System.out.println("TC Passed");
		}
		else
		{
			System.out.println("TC Fail");
		}

		//logout Vtiger application
		driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}

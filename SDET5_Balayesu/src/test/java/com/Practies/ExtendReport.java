package com.Practies;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReport {
	
	WebDriver driver;
	
	// to give the path,configuration, title, report name
	ExtentSparkReporter reporter;
	
	// Attach reporter name ,flush,config
	ExtentReports reports;
	
	// to create entries in the report
	ExtentTest test;
	
	@Test
	
	public void testReport() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		reporter = new ExtentSparkReporter("./ExtentReport.html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("VTR");
		reporter.config().setReportName("sample test");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Reporter Name", "Balayesu");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Reporter Name", "Balayesu");
		reports.setSystemInfo("Build", "1.2.23");
		
		test = reports.createTest("Login page");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/loginpage.png");
		Files.copy(src, dest);
		
		test.addScreenCaptureFromBase64String("./screenshot/loginpage.png");
		reports.flush();
		
	}

	}

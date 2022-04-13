package com.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.google.common.io.Files;

public class Listeners_Execution extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot takescreenshot = (TakesScreenshot)sdriver;
		File src=takescreenshot.getScreenshotAs(OutputType.FILE);
		//String pathname = IAutoConstants.screenshotpath+result.getName()+".png";
		//String pathname ="C:\\Users\\sivaram\\eclipse-workspace\\SDET5_Balayesu\\screenshot\\image1.png";
		//String pathname="./screenshot/image1.png";
		//File dest = new File(IAutoConstants.screenshotpath+result.getMethod().getMethodName()+".png");
		File dest = new File(IAutoConstants.screenshotpath+result.getMethod().getMethodName()+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

  
}

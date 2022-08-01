package com.Practies;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
   
	@Test(dataProvider="provideData")
	public void testMethod(String name , int age)
	{
		System.out.println("MY Name is :"+name+"   My Age : "+ age );
	}
	 @DataProvider
	 public Object[][] provideData()
	 {
		 Object[][] obj = new Object[2][2];
		 obj[0][0]="Balayesu";
		 obj[0][1]=25;
		 
		 obj[1][0]="Krishna";
		 obj[1][1]=26;
		 
		 return obj;
	 }
}

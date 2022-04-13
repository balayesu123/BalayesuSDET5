package com.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AfterAnnotationsTest {
	
	@Test
	public void a()
	{
		System.out.println(" @TestAfter");
	}
	@AfterSuite
	public void h()
	{
		System.out.println(" @AfterSuite");
	}
	@AfterTest
	public void i()
	{
		System.out.println(" @AfterTest");
	}
	@AfterClass
	public void j()
	{
		System.out.println(" @AfterClass");
	}
	@AfterMethod
	public void k()
	{
		System.out.println(" @AfterMethod");
	}
}

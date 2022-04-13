package com.testNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotationsTest {
//	@BeforeMethod
//	public void before()
//	{
//		System.out.println("@BeforeMethod");
//	}

	@Test(invocationCount = 3)
	public void a()
	{
		System.out.println(" @Test1");
	}
	
	@Test()
	public void b()
	{
		System.out.println(" @Test2");
	}
	
	@Test()
	public void c()
	{
		System.out.println(" @Test3");
	}
	@Test()
	public void d()
	{
		System.out.println(" @Test4");
	}
//	@AfterMethod
//	public void after()
//	{
//		System.out.println("@AfterMethod");
//	}
	
	

}

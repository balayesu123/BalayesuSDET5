package com.testNg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAnnotationsTest {
	
	@Test
	public void a()
	{
		System.out.println(" @TestBefore");
	}
 
	@BeforeSuite
	public void b()
	{
		System.out.println(" @BeforeSuite");
	}

	@BeforeTest
	public void c()
	{
		System.out.println("@BeforeTest");
	}
	@BeforeClass
	public void e()
	{
		System.out.println("@BeforeClass");
	}
	@BeforeMethod
	public void g()
	{
		System.out.println("@BeforeMethod");
	}
}

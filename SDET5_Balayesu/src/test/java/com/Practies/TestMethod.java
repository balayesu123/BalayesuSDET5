package com.Practies;

import org.testng.annotations.Test;

public class TestMethod {
    @Test   
    public void display()  // one @Test annotation run only one method
    {
    	System.out.println("test2");
    }
    public void sample()
    {
    	System.out.println("test1");
    }
   
}

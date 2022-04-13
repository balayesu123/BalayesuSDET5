package com.PractiesApp;

public class Singleton {
	
	private static Singleton obj;
	 String name = "bala";
     int age = 25;
    private Singleton()
    {
    	
    }
    public static Singleton getobj()
    {
    	
    	 obj=new Singleton();
    	
    	return obj;
    }
}

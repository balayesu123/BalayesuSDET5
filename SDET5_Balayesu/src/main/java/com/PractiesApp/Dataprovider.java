package com.PractiesApp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
   @Test(dataProvider="dataproviderMethod")
   public void testMethod(String src,String dest,String stop)
   {
	   System.out.println(src);
	   System.out.println(dest);
	   System.out.println(stop);
   }
   @DataProvider
   public Object[][] dataproviderMethod()
   {
	   Object[][] obj=new Object[3][3];
	   obj[0][0]="HYD";
	   obj[0][1]="PUNE";
	   obj[0][2]="DELHI";
	   
	   obj[1][0]="MUMBAI";
	   obj[1][1]="KOLKATHA";
	   obj[1][2]="CHENNAI";
	   
	   obj[2][0]="BEN";
	   obj[2][1]="VIZAG";
	   obj[2][2]="GOVA";
	   
	   return obj;
   }
}

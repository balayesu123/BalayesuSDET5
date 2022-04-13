package com.CRM.TestCases;

import com.generic.ExcelUtil;
import com.generic.IAutoConstants;

public class Read_Data_MoreThan_32000 {
	
  public static void main(String[] args) throws Throwable {
	
	  ExcelUtil excelUtil = new ExcelUtil();
	  
			int lastrow=excelUtil.getRowCount(IAutoConstants.excelpath, "Sheet1");

			for (int i = 0; i <= lastrow; i++) 
			{
				
			      int salary=excelUtil.readNumericdatafromExcel(IAutoConstants.excelpath, "Sheet1", i, 1);
			      
			      if(salary>=32000)
			      {
			    	  String name=excelUtil.readStringdatafromExcel(IAutoConstants.excelpath, "Sheet1", i, 0);
			    	  System.out.println(name);
			      
			      }
			
			}
		
}
}

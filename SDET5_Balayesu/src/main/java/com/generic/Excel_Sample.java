package com.generic;

public class Excel_Sample {
	
	public void launchbrowser() throws Throwable 
	{
		ExcelUtil excelUtil = new ExcelUtil();
		int lastrow=excelUtil.getRowCount(IAutoConstants.excelpath, "Sheet1");

		for (int i = 0; i <= lastrow; i++) 
		{
			System.out.println(excelUtil.readStringdatafromExcel(IAutoConstants.excelpath, "Sheet1", i, 0));
		}
	}
}

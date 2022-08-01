package com.PractiesApp;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven_ExcelSheet {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("./DataDriven.xlsx");
		Workbook w =WorkbookFactory.create(fis);

		// ********** get specific data *************

		//String data = w.getSheet("Sheet1").getRow(1).getCell(2).toString();  //  String value = getStringCellValue()  
		//System.out.println(data);                                            //  double value = getNumericCellValue()
		

		// ***********get last row number and get last colum number ***************

		/*	int row = w.getSheet("Sheet1").getLastRowNum();
		System.out.println("Rows :  "+row);
		
		int colum = w.getSheet("Sheet1").getRow(0).getLastCellNum();
		System.out.println("colums :  "+colum); */
		
		int rows = w.getSheet("Sheet1").getLastRowNum();
		
		for(int i=0 ; i<=rows ; i++)
		{
			int colums = w.getSheet("Sheet1").getRow(i).getLastCellNum();

			for(int j=0 ; j<colums ; j++)
			{
				String currentCell = w.getSheet("Sheet1").getRow(i).getCell(j).toString();
				System.out.print(" "+currentCell+" ");
			}
			System.out.println();
		}

	}

}

package com.sevenmarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmarket.utilities.ExcelReader;

public class DataProviders {
	
	ExcelReader excelread=new ExcelReader();
	
	@DataProvider(name="Manage News")
	public Object[][] addNews()
	{
		excelread.setExcelFile("AddNews");
		return excelread.getMultidimentionalData(3,1);
	}
	
	
	
	

}

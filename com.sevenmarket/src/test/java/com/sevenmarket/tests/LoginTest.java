package com.sevenmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmarket.base.Base;
import com.sevenmarket.pages.HomePage;
import com.sevenmarket.pages.LoginPage;
import com.sevenmarket.utilities.ExcelReader;

public class LoginTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader=new ExcelReader();
	
	
	
	@Test(groups="smoke")
	public void verifyValidLogin()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
	//	loginpage.login("admin", "admin");
		loginpage.verifyValidLogin();
		String actual=homepage.getProfileName();
		String expected="Admin";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(groups={"regression","smoke"})
	public void verifyInvalidLogin()
	{
		loginpage=new LoginPage(driver);
		boolean actual=loginpage.ErrormessageOnInvalidLogin("adfg", "asdfhhs");
		
		Assert.assertEquals(actual, true);
	}
	
	
	
	@Test
	public void dummyTestCase()
	{
		
		excelreader.setExcelFile("Login");
		String data=excelreader.getCellData(1, 1);
		System.out.println(data);
		//Assert.assertTrue(true);
	}
	
	

}

package com.sevenmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmarket.base.Base;
import com.sevenmarket.dataproviders.DataProviders;
import com.sevenmarket.pages.HomePage;
import com.sevenmarket.pages.LoginPage;
import com.sevenmarket.pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	
	
	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage managenews;
	
	@Test
	public void VerifyUserAbleToAddNews() throws InterruptedException
	{
		loginpage=new LoginPage(driver);
		//homepage=new HomePage(driver);
		managenews=new ManageNewsPage(driver);
		homepage=loginpage.verifyValidLogin();
		homepage.manageNewsInfoClick();
		Thread.sleep(2000);
		managenews.clickOnNewButton().enterTextInNewsField("Hi").clickOnSaveButton();
		Thread.sleep(6000);

		
		
		
	}
	
	
	@Test(dataProvider = "Manage News", dataProviderClass = DataProviders.class)
	public void verifyAlertMessageIsDisplayed(String news)
	{
		loginpage=new LoginPage(driver);
		//homepage=new HomePage(driver);
		managenews=new ManageNewsPage(driver);
		homepage=loginpage.verifyValidLogin();
		homepage.manageNewsInfoClick();
		String actual=managenews.getTextAlert(news);
		System.out.println(actual);
		String expected="Alert";
		
		Assert.assertEquals(actual, expected);
		
		
	}
	
	
	
	
	
	
	
	
	

}

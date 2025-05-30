package com.sevenmarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sevenmarket.base.Base;
import com.sevenmarket.pages.HomePage;
import com.sevenmarket.pages.LoginPage;

public class HomeTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	
	
	@Test(groups={"regression","smoke"})
	
	public void verifyAdminUserMoreInfoClick()
	{
		loginpage=new LoginPage(driver);
	homepage=new HomePage(driver);
	loginpage.verifyValidLogin();
	homepage.adminMoreInfoClick();
		
	}
	
	@Test
	public void verifyManageNewsInfoClick()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.verifyValidLogin();
		homepage.adminMoreInfoClick();
	}
	

	
	
	
	
}

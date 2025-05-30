package com.sevenmarket.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmarket.base.Base;
import com.sevenmarket.pages.AdminUsersPage;
import com.sevenmarket.pages.HomePage;
import com.sevenmarket.pages.LoginPage;

public class AdminUsersTest extends Base{
	
    LoginPage loginpage;
    HomePage homepage;
	AdminUsersPage adminuserspage;
	
	@Test
	
	public void verifyTableHeaderText()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.verifyValidLogin();
		homepage.adminMoreInfoClick();
		List<String> actual=adminuserspage.getTableHeaders();
		System.out.println(actual);
		List<String> expected=new ArrayList<>(Arrays.asList("Username", "Usertype", "Status", "Password", "Action"));
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test
	
	public void alertDisplayedOnAddingInfo() throws InterruptedException
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.verifyValidLogin();
		adminuserspage=homepage.adminMoreInfoClick();
		adminuserspage.clickNewButton().enterUsernameAndPassword("apple", "admins").selectDropDown("Partner").clickSave();
		Thread.sleep(6000);
		adminuserspage.alertIsDisplayed();
		Assert.assertTrue(adminuserspage.alertIsDisplayed());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

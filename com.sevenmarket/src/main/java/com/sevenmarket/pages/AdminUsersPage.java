package com.sevenmarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmarket.utilities.GeneralUtility;



public class AdminUsersPage {
	
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();

	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//thead//tr//th")
	List <WebElement> tableheaders;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getTableHeaders()
	{
		return generalutility.getTextofElements(tableheaders);
	}

	
	
	
	
	
	
	
	
	
	

	
	
	
	
}

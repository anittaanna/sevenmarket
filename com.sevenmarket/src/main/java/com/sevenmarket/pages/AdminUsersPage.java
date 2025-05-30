package com.sevenmarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmarket.utilities.GeneralUtility;
import com.sevenmarket.utilities.PageUtility;



public class AdminUsersPage {
	
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	PageUtility pageutility;

	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//thead//tr//th")
	List <WebElement> tableheaders;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(id="username")
	WebElement usernamefield;
	@FindBy(id="password")
	WebElement passwordfield;
   @FindBy(xpath="//i[@class='fa fa-save']")
   WebElement savebutton;
   @FindBy(id="user_type")
   WebElement selectdropdown;
   @FindBy(xpath="//h5[contains(text(), 'Alert!')]")
   WebElement alert;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getTableHeaders()
	{
		return generalutility.getTextofElements(tableheaders);
	}
	
	public AdminUsersPage clickNewButton()
	{
		newbutton.click();
		return this;
	}

	public AdminUsersPage enterUsernameAndPassword(String username, String Password)
	{
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(Password);
		return this;
	}
	
	public AdminUsersPage selectDropDown(String visibletext)
	{
		pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleText(selectdropdown, visibletext);
		return this;
	}
	
	public AdminUsersPage clickSave()
	{
		savebutton.click();
		return this;
	}
	
	public boolean alertIsDisplayed()
	{
		return alert.isDisplayed();
	}
	
	
	
	
	

	
	
	
	
}

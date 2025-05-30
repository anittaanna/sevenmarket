package com.sevenmarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class ManageNewsPage {

	WebDriver driver;

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement newsfield;
	@FindBy(xpath="//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManageNewsPage clickOnNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterTextInNewsField(String news)
	{
		newsfield.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage clickOnSaveButton()
	{
		savebutton.click();
		return this;
	}
	
	public void AddNews(String news)
	{
		clickOnNewButton();
		enterTextInNewsField(news);
		clickOnSaveButton();
	}
	
	public String getTextAlert(String news)
	{
		AddNews(news);
		return alert.getText();
	}
	
	
}

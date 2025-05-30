package com.sevenmarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profilename;
	
	@FindBy(xpath="//p[text()='Admin Users']/following::a[1]")
	WebElement adminusers;
	
	@FindBy(xpath="(//p[text()='Manage News'])[2]/following::a[1]")
	WebElement managenews;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
			
	public String getProfileName()
	{
		return profilename.getText();
	}
	
	
	public AdminUsersPage adminMoreInfoClick()
	{
		adminusers.click();
		return new AdminUsersPage(driver);
	}
	
	
	public void manageNewsInfoClick()
	{
		managenews.click();;
	}
	
	
	
	
	
	

}

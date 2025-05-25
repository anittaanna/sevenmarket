package com.sevenmarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmarket.constants.Constants;
import com.sevenmarket.utilities.WaitUtility;

public class LoginPage {
	
WebDriver driver;

Properties properties = new Properties();// to read from properties


@FindBy(xpath="//input[@name='username']")
private WebElement usernamefield;

@FindBy(xpath="//input[@name='password']")
private WebElement passwordfield;

@FindBy(xpath="//button[text()='Sign In']")
private WebElement signinbutton;

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
WebElement errormessage;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try {

			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUsername(String username)
	{
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void clickOnSigninButton()
	{
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.Element_to_be_Clickable(signinbutton, 30);
		signinbutton.click();
	}
	
	 // to wrap all methods 
	public void login(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickOnSigninButton();
	}
	
	// to read user & pass from config also function
	
	
	
	//	public void validLogin()
		//{
		//	String userName=properties.getProperty("username");
		//	String Password=properties.getProperty("password");
		//	enterUsername(userName);
		//	enterPassword(Password);
		//	clickOnSigninButton();
	//	}
	
	public void verifyValidLogin()
	{
		enterUsername(properties.getProperty("username"));
		enterPassword(properties.getProperty("password"));
		clickOnSigninButton();
	}
	
	public  boolean ErrormessageOnInvalidLogin(String username, String password)
	{
		
		enterUsername(username);
		enterPassword(password);
		clickOnSigninButton();
		return errormessage.isDisplayed();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

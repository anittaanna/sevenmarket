package com.sevenmarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility { // used for scroll , java script execitor

	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void select_ByVisibleText(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}

	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// scroll & click

	public void scrollAndClick(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
	}

	// Do mouse actions
	
	public void flyoutOfElement(WebElement element)
	{
		actions.moveToElement(element).build().perform();
	}
	
	public void clickOnFlyoutDisplayed(WebElement element, WebElement target)
	{
		flyoutOfElement(element);
		actions.click(target).build().perform();
	}
	
	
	
	
	
	
	
	
	

}

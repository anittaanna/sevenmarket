package com.sevenmarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;

	}

	public void Element_to_be_Clickable(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		// WebElement button=driver.findElement(By.id("save"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		// button.click();

	}
	
	
	
	
	

}

package com.sevenmarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmarket.constants.Constants;
import com.sevenmarket.utilities.CaptureScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;

	Properties properties = new Properties();// to read from properties
	CaptureScreenshots capturescreenshots=new CaptureScreenshots();

	public Base() { // constructor
		try {

			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initialize **/

	public void initialize(String browser, String url) {
		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		else if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

	}
	
	@Parameters("browser")
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser) {
     String url=properties.getProperty("url");   // to call variables from config files  just adding key value pair
     
     initialize(browser, url);
     
     
     
	}
	

@BeforeMethod(enabled=true, alwaysRun = true)
	public void launchBrowser() {
     String url=properties.getProperty("url");   // to call variables from config files  just adding key value pair
     String browser=properties.getProperty("browser");
     
     initialize(browser, url);
     
     
     
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void terminateSession(ITestResult itestresult) // itestresult is a listener
	{
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			capturescreenshots.takeScreenShot(driver, itestresult.getName());
		}
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}

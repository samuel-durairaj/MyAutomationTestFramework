package com.web.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import com.web.actiondriver.Action;

public class BaseClass {

	//public static WebDriver driver;
	public static Properties prop;
	
	//Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	public static WebDriver getDriver() {
		//Get Driver from thread local camp
		return driver.get();
	}
	
	@BeforeTest
	public void loadConfig() {
		try {
			prop=new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp() {
		//WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			System.setProperty(browserName, "C:\\Drivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			//Set Browser to ThreadLocalCamp
			driver.set(new ChromeDriver());
		}else if (browserName.contains("FireFox")) {
			//driver = new FirefoxDriver();
			//Set Browser to ThreadLocalCamp
			driver.set(new FirefoxDriver());
		}else if (browserName.contains("IE")) {
			//driver = new InternetExplorerDriver();
			//Set Browser to ThreadLocalCamp
			driver.set(new InternetExplorerDriver());
		}
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
	}
}
package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.web.base.BaseClass;
import com.web.dataprovider.DataProviders;
import com.web.pageobjects.HomePage;
import com.web.pageobjects.IndexPage;
import com.web.pageobjects.LoginPage;
import com.web.utility.Log;

public class LoginPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod (groups = { "Smoke", "Sanity", "Regression" })
	@Parameters({"browserName"})
	public void setUp(String browserName) {
		launchApp(browserName);
	}
	
	@AfterMethod (groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (dataProvider="credentials", dataProviderClass=DataProviders.class) 
	public void loginTest(String username, String password) throws Throwable {
		Log.startTestCase("Login Test");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(username, password);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "https://www.automationexercise.com";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is successful");
		Log.endTestCase("Login Test");
	}
}

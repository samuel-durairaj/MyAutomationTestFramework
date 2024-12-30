package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.web.base.BaseClass;
import com.web.pageobjects.HomePage;
import com.web.pageobjects.IndexPage;
import com.web.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {

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
	
	@Test (groups = { "Smoke", "Sanity"})
	public void homePageValidationTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.loggedInAsUserLabel();
		Assert.assertTrue(result);
	}
}

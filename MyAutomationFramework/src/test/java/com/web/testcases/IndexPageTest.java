package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.web.utility.Log;
import com.web.base.BaseClass;
import com.web.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {

	IndexPage indexPage;
	
	@BeforeMethod (groups = { "Smoke", "Sanity", "Regression" })
	@Parameters({"browserName"})
	public void setUp(String browserName) {
		launchApp(browserName);
	}

	@Test (groups = "Smoke")
	public void verifyLogo() throws Throwable{
		Log.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test (groups = "Smoke")
	public void verifyTitle() throws Throwable{
		Log.startTestCase("verifyTitle");
		String title = indexPage.getHomePageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		Log.endTestCase("verifyTitle");
	}
	
	@AfterMethod (groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
}

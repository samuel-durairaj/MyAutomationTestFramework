package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.BaseClass;
import com.web.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {

	IndexPage indexPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}

	@Test
	public void verifyLogo() throws Throwable{
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() throws Throwable{
		String title = indexPage.getHomePageTitle();
		Assert.assertEquals(title, "Automation Exercise");
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}

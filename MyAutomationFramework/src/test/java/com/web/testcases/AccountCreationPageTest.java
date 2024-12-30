package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.web.base.BaseClass;
import com.web.pageobjects.AccountCreationPage;
import com.web.pageobjects.IndexPage;
import com.web.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod (groups = { "Smoke", "Sanity", "Regression" })
	@Parameters({"browserName"})
	public void setUp(String browserName) {
		launchApp(browserName);
	}
	
	@AfterMethod (groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (groups = "Regression")
	public void verifyCreateAccountPageTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.signUp("samuel", "samuel86@mail.com");
		boolean result = accountCreationPage.accountCreationHeaderTitle();
		Assert.assertTrue(result);
	}
}

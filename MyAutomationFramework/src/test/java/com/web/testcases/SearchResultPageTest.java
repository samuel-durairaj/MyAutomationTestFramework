package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.BaseClass;
import com.web.pageobjects.HomePage;
import com.web.pageobjects.IndexPage;
import com.web.pageobjects.LoginPage;
import com.web.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		searchResultPage = homePage.ClickProductsLink();
		boolean searchWaterMarkLabel = searchResultPage.isSearchWaterMarkLabel();
		Assert.assertTrue(searchWaterMarkLabel);
		searchResultPage.enterSearchText("Men Tshirt");
		searchResultPage.clickSubmitSearch();
		searchResultPage.mouseHoverTheProduct();
//		boolean productAvl = searchResultPage.isProductAvailable();
//		Assert.assertTrue(productAvl);
//		searchResultPage.clickOnProduct();
//		boolean addToCartModalConfirmationMsg=searchResultPage.addToCartConfirmationMessage();
//		Assert.assertTrue(addToCartModalConfirmationMsg);
//		searchResultPage.clickViewCartModal();
	}
}

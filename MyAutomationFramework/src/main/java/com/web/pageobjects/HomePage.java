package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement LogoutButton;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement ProductsLink;
	
	@FindBy(xpath="//a[text()=' Logged in as ']")
	WebElement LoggedAsUserLabel;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickLogoutButton() throws Throwable {
		Action.click(getDriver(), LogoutButton);
		return new LoginPage();
	}
	   
    public SearchResultPage ClickProductsLink() throws Throwable{
    	Action.click(getDriver(), ProductsLink);
    	return new SearchResultPage();
    }
    
    public boolean loggedInAsUserLabel() throws Throwable {
    	return Action.isDisplayed(getDriver(), LoggedAsUserLabel);
    }
    
    public String getCurrURL() {
    	String currentURL = getDriver().getCurrentUrl();
    	return currentURL;
    }
}

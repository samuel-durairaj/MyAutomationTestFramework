package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

//Page Objects in Page Class

public class IndexPage extends BaseClass{

	@FindBy(xpath="//img[@src='/static/images/home/logo.png']")
    WebElement HomePageLogo;
	
	@FindBy(xpath="//*[text()=\" Signup / Login\"]")
	WebElement LoginOrSignUpButton;
    
    //Using Constructor to initialise the webelements
    public IndexPage() {
    	PageFactory.initElements(getDriver(), this);
    }
    
    public boolean validateLogo() throws Throwable{
    	return Action.isDisplayed(getDriver(), HomePageLogo);
    }
    
    public String getHomePageTitle() {
    	String homePageTitle = getDriver().getTitle();
    	return homePageTitle;
    }
    
    public LoginPage clickOnSignIn() throws Throwable{
    	Action.click(getDriver(), LoginOrSignUpButton);
    	return new LoginPage();
    }
}

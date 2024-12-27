package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class AccountCreationPage extends BaseClass{

	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
	WebElement AccountCreationHeaderTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean accountCreationHeaderTitle() throws Throwable {
		return Action.isDisplayed(getDriver(), AccountCreationHeaderTitle);
	}
}

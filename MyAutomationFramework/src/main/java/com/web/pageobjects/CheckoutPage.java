package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class CheckoutPage extends BaseClass {

	@FindBy (xpath = "//*[text()='Place Order']")
	WebElement PlaceOrderButton;
	
	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickPlaceOrderButton() {
		Action.click(getDriver(), PlaceOrderButton);
	}
}

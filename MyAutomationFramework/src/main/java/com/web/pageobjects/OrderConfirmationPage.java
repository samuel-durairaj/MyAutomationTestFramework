package com.web.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.web.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
}

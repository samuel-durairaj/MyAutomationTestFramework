package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(xpath="//*[text()='Proceed To Checkout']")
	WebElement ProceedCheckoutButton;
	
	@FindBy(xpath="//*[@id=\"product-1\"]/td[3]/p")
	WebElement UnitPrice;
	
	@FindBy(xpath="//*[@id=\"product-1\"]/td[5]/p")
	WebElement TotalPrice;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckoutPage proceedCheckoutButton() {
		Action.click(getDriver(), ProceedCheckoutButton);
		return new CheckoutPage();
	}
	
	public double getUnitPrice() {
		String unitPrice1 = TotalPrice.getText();
		String unitPriceVal = unitPrice1.replaceAll("[A-Za-z^.]", "");
		double finalUnitPrice = Double.parseDouble(unitPriceVal);
		return finalUnitPrice;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = TotalPrice.getText();
		String totalPriceVal = totalPrice1.replaceAll("[A-Za-z^.]", "");
		double finalTotalPrice = Double.parseDouble(totalPriceVal);
		return finalTotalPrice;
	}
}

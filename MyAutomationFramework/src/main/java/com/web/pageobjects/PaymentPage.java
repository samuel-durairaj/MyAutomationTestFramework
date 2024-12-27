package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy (name = "name_on_card")
	WebElement NameOnCard;
	
	@FindBy (name = "card_number")
	WebElement CardNumber;
	
	@FindBy (name = "cvc")
	WebElement CVVNumber;
	
	@FindBy (name = "expiry_month")
	WebElement ExpiryMonth;
	
	@FindBy (name = "expiry_year")
	WebElement ExpiryYear;
	
	@FindBy (id="submit")
	WebElement PayAndConfirmOrder;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterCardDetails(String nameOnCard, String cardNumber, String cvvNumber, String expiryMonth, String expiryYear) {
		Action.type(NameOnCard, nameOnCard);
		Action.type(CardNumber, cardNumber);
		Action.type(CVVNumber, cvvNumber);
		Action.type(ExpiryMonth, expiryMonth);
		Action.type(ExpiryYear, expiryYear);
	}
	
	public OrderConfirmationPage clickPayAndConformOrder() {
		Action.click(getDriver(), PayAndConfirmOrder);
		return new OrderConfirmationPage();
	}
}

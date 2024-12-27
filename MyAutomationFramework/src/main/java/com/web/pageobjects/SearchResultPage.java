package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath="//*[@id='search_product']")
	WebElement SearchWatermarkText;
	
	@FindBy(xpath="//*[@id='submit_search']")
	WebElement SubmitSearch;
	
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p")
	WebElement MenTShirtProduct;
	
	@FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
	WebElement ViewCartModal;
	
	@FindBy(xpath="//*[text()='Your product has been added to cart.']")
	WebElement AddToCartConfirmationMessage;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
    
	public boolean isSearchWaterMarkLabel() {
		return Action.isDisplayed(getDriver(), SearchWatermarkText);
	}
	
	public void enterSearchText(String enterText) {
		Action.type(SearchWatermarkText, enterText);
	}
	
	public void clickSubmitSearch() {
		Action.click(getDriver(), SubmitSearch);
	}
	
	public void mouseHoverTheProduct() {
		Action.mouseover(getDriver(), MenTShirtProduct);
	}
	
	public AddToCartPage clickViewCartModal() throws Throwable {
		Action.click(getDriver(), ViewCartModal);
		return new AddToCartPage();
	}
	
	public boolean isProductAvailable() throws Throwable{
		return Action.isDisplayed(getDriver(), MenTShirtProduct);
	}
	
	public void clickOnProduct() throws Throwable{
		Action.click(getDriver(), MenTShirtProduct);
	}
	
	public boolean addToCartConfirmationMessage() {
		return Action.isDisplayed(getDriver(), AddToCartConfirmationMessage);
	}
}


/**
 * 
 */
package com.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.actiondriver.Action;
import com.web.base.BaseClass;

public class LoginPage extends BaseClass {

	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]")
	    WebElement Username;
	    
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[3]")
	    WebElement Password;
	    
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button")
	    WebElement LoginButton;
	    
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
	    WebElement NameForSignUp;
	    
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
	    WebElement EmailForSignUp;
	    
	    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	    WebElement SignUpButton;
	
	    //Constructors to Initialise the WebElements
	    public LoginPage() {
	    	PageFactory.initElements(getDriver(), this);
	    }
	    
	    public HomePage login(String username, String password) throws Throwable {
	    	Action.type(Username, username);
	    	Action.type(Password, password);
	    	Action.click(getDriver(), LoginButton);
            return new HomePage();
	    }
	    
	    public AccountCreationPage signUp(String name, String emailID) throws Throwable{
	    	Action.type(NameForSignUp, name);
	    	Action.type(EmailForSignUp, emailID);
	    	Action.click(getDriver(), SignUpButton);
	    	return new AccountCreationPage();
	    }
}

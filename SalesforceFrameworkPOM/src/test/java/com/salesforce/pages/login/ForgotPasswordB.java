package com.salesforce.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class ForgotPasswordB extends BasePage{
	
	//locating error message
		@FindBy(xpath="//*[@id=\"error\"]")WebElement searchElement3; 
	
public ForgotPasswordB (WebDriver driver) {
		
		super(driver);
	}

public String getErrorMessage() {
	
 	String errormessage = searchElement3.getText();
 			
 		return errormessage;}
}

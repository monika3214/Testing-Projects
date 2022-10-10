package com.salesforce.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class FailLoginPage extends BasePage{
	//locating error message
	@FindBy(id="error")WebElement searchElement3; 
	
public FailLoginPage (WebDriver driver) {
		
		super(driver);
	}
	
		public String getErrorMessage() {
	
 	String errormessage = searchElement3.getText();
 			
 		return errormessage;}

}

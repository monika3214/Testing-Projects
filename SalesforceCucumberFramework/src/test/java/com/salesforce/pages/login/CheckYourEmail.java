package com.salesforce.pages.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class CheckYourEmail extends BasePage{
	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/a")WebElement returnbutton; 
	
public CheckYourEmail (WebDriver driver) {
		
		super(driver);
	}
  
public void clickReturn() {
	
	try {
		clickElement(returnbutton,"return");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
   
}

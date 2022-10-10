package com.salesforce.pages.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class RemeberMeLoginPage extends BasePage{
	//@FindBy(id="idcard-identity")WebElement searchElement; 
	@FindBy(xpath="//*[@id=\"idcard-identity\"]")WebElement searchElement; 
	
public RemeberMeLoginPage(WebDriver driver){
		
		super(driver);
	}
	
@FindBy(id="rememberUn")WebElement searchElement3; 

	public void clickRememberMe() {
		
		try {
			clickElement(searchElement3, "RememberMe checkbox");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String nowText() {
		String str =searchElement.getText();
	System.out.println(str);
	return str;
	}
	

}

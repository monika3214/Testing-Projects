package com.salesforce.pages.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.salesforce.pages.base.BasePage;

public class ForgotPasswordAPage extends BasePage{
	
	//user name text box
	//@FindBy(id="un")WebElement searchElementun;
	@FindBy(xpath="//*[@id=\"un\"]")WebElement searchElementun;
	//continue button
	@FindBy(id="continue")WebElement searchElementcn;
	@FindBy(id="forgot_password_link")WebElement searchElementfp; 

public ForgotPasswordAPage (WebDriver driver) {
		
		super(driver);
	}





public void enterUsername(String username1) {
	try {
		enterText(searchElementun, username1, "user name");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	
public void clickContinue() {
	try {
		clickElement(searchElementcn, "continue");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void clickForgotPasswordlink() {
	try {
		clickElement(searchElementfp, "forgot password link");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}

}
/*WebElement searchElement = driver.findElement(By.id("forgot_password_link"));
clickElement(searchElement, "forgot_password_link");
WebElement searchElement1 = driver.findElement(By.id("un"));
				enterText(searchElement1, readPropertyData("username"), "user name");				
				WebElement searchElement2 = driver.findElement(By.id("continue"));
				clickElement(searchElement2, "continue");			
*/	
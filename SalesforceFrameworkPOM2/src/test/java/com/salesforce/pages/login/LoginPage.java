package com.salesforce.pages.login;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.pages.base.BasePage;

public class LoginPage extends BasePage{
	
	
	//username
	@FindBy(id="username")WebElement searchElement; 
	//password
	@FindBy(id="password")WebElement searchElement1;
	//login
	@FindBy(id="Login")WebElement searchElement2;
	
	public LoginPage (WebDriver driver) {
		
		super(driver);
	}
		public void enterUsername(String username) {
			try {
				enterText(searchElement, username, "user name");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		
		public void enterPassword(String password) {
			try {
				enterText(searchElement1, password, "password");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		public void clickLoginButton() {
			try {
				clickElement(searchElement2, "Login button");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void Login(String username, String password) {
			
			enterUsername(username);
			enterPassword(password);
			clickLoginButton();
			
			
			
		}
		}
		
		



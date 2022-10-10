package com.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.page.Page;
import org.testng.Assert;

import com.salesforce.baseclass.BaseTest;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.login.CheckYourEmail;
import com.salesforce.pages.login.FailLoginPage;
import com.salesforce.pages.login.ForgotPasswordAPage;
import com.salesforce.pages.login.ForgotPasswordB;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.pages.login.RemeberMeLoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceStepDefinition {
	
	WebDriver driver;
	LoginPage loginpage1;
	HomePage homepage;
	ForgotPasswordAPage forgotpasswordA;
	
	@Before(order=0)
	public void setup1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@SuppressWarnings("deprecation")
	@Before(order=1)
	public void setup2(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@After
	public void tearDowb(){driver.close();}
	
	@Given("whenI go to url {string}")
	public void when_i_go_to_url(String url) {
	    driver.get(url);
	}
	
	@When("I am on {string}")
	public void i_am_on(String string) throws InterruptedException {
	    loginpage1 = new LoginPage(driver);
	    System.out.println("loginpage loaded");
	    
	    Thread.sleep(6000);
	}
	
	@When("I enter value of username as {string} and password as {string}")
	public void i_enter_value_of_username_as_and_password_as(String username, String password) throws IOException {
	System.out.println(username+ " "+ password  );
		loginpage1.Login(username, password);
		System.out.println(username+ " "+ password  );
	    
	}
	@When("click on login button")
	public void click_on_login_button() {
		loginpage1.clickLogin();
	    
	}
	@Then("I should get page title as {string}")
	public void i_should_get_page_title_as(String string) throws InterruptedException, IOException {
HomePage homepage = new HomePage(driver);
		
		String actual =	homepage.homeTitle();
		System.out.println(actual);
		
			    Thread.sleep(2000);
			   // String actual = getTitle();
			    String expected ="Home Page ~ Salesforce - Developer Edition";
			    System.out.println(expected);
			    Assert.assertEquals(actual, expected);}
	
	@Then("I should get error message  as {string}")
	public void i_should_get_error_message_as(String string) {
		FailLoginPage failloginpage = new FailLoginPage(driver);
		String actual = failloginpage.getErrorMessage();
		String expected = "Please enter your password.";
		 Assert.assertEquals(actual, expected);
	}
	@Given("when I go to url {string}")
	public void when_i_go_to_url1(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("I click  checkme checkbox")
	public void i_click_checkme_checkbox() {
		RemeberMeLoginPage rememberme = new RemeberMeLoginPage(driver);
		rememberme.clickRememberMe();
	}
	@When("I click logout button")
	public void i_click_logout_button() {
		HomePage homepage = new HomePage(driver);
		homepage.clickUserNav();
		homepage.clickLogout();
	}
	@Then("I should get  username textbox as {string}")
	public void i_should_get_username_textbox_as(String string) {
		System.out.println("hi i am here");
		RemeberMeLoginPage rememberme = new RemeberMeLoginPage(driver);
		System.out.println("hi i ma here too");
		String actual = rememberme.nowText();
		System.out.println("i am here again");
				System.out.println(actual);
		String expected = "monika@braves.com";
		Assert.assertEquals(actual, expected);
	}
	@Then("I should get error message  as1 {string};")
	public void i_should_get_error_message_as1(String string) {
		ForgotPasswordB forgotpasswordB = new ForgotPasswordB(driver);
		String actual = forgotpasswordB.getErrorMessage();
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(actual, expected);
	}
	@When("I click  forgot password")
	public void i_click_forgot_password() {
	  
	   loginpage1.clickForgotPasswordlink();
	   
	   
	}
	@When("I enter value of username as {string}")
	public void i_enter_value_of_username_as(String username1) throws InterruptedException {
		 ForgotPasswordAPage forgotpasswordA = new ForgotPasswordAPage(driver);
		Thread.sleep(8000);
		forgotpasswordA.enterUsername(username1);
		   forgotpasswordA.clickContinue();
		//forgotpasswordA.enterUsername(username1);
		
	}
	@When("I click Continue button")
	public void i_click_continue_button() {
		//forgotpasswordA.clickContinue();
	}
	@When("I click Return Button")
	public void i_click_return_button() {
	    CheckYourEmail chemail = new CheckYourEmail(driver);
	    chemail.clickReturn();
	}
	
	@Then("I should get page title as1 {string}")
	public void i_should_get_page_title_as1(String string) throws InterruptedException {
		String actual =	loginpage1.getTitle();
		System.out.println(actual);
		
			    Thread.sleep(2000);
			   // String actual = getTitle();
			    String expected ="Login | Salesforce";
			    System.out.println(expected);
			    Assert.assertEquals(actual, expected);
	    
	}
	    
	}



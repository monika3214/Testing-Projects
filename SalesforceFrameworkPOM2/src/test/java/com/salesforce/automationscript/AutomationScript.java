package com.salesforce.automationscript;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.autimationscript.utility.CommonUtilities;
import com.salesforce.baseclass.BaseTest;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.login.FailLoginPage;
import com.salesforce.pages.login.ForgotPasswordA;
import com.salesforce.pages.login.ForgotPasswordB;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.pages.login.RemeberMeLoginPage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;


public class AutomationScript extends BaseTest {
	//CommonUtilities cu = new CommonUtilities();
	
	@Test
	public static void loginToSalesForceTC02() throws InterruptedException, IOException {
			   
		LoginPage login = new LoginPage(driver);
		login.Login(readPropertyData("username"), readPropertyData("password"));
		HomePage homepage = new HomePage(driver);
		
		String actual =	homepage.homeTitle();
		
			    Thread.sleep(2000);
			   // String actual = getTitle();
			    String expected = readPropertyData("actualTC02");
			    Assert.assertEquals(actual, expected);}
	
	
	@Test
	public static void loginErrorMessageTC01() throws InterruptedException, IOException {
		
		LoginPage login = new LoginPage(driver);
		login.Login(readPropertyData("username"), "");
		
		FailLoginPage failloginpage = new FailLoginPage(driver);
		String actual = failloginpage.getErrorMessage();
		String expected = readPropertyData("errormessageactualTC01");
		 Assert.assertEquals(actual, expected);
	}
	
	@Test
	public static void checkRememberMeTC03() throws InterruptedException, IOException {		

		RemeberMeLoginPage rememberme = new RemeberMeLoginPage(driver);
		rememberme.clickRememberMe();
		LoginPage login = new LoginPage(driver);
		login.Login(readPropertyData("username"), readPropertyData("password"));
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserNav();
		
		
		//WebElement myDynamicElement = 
			//	(new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")));
		homepage.clickLogout();
		Thread.sleep(6000);
		String actual = login.getTitle();
		System.out.println(actual);
		String expected = readPropertyData("pageactualTC03");
		Assert.assertEquals(actual, expected);
		
		
}
	
	@Test
	public static void forgotPasswardTC04A() throws InterruptedException, IOException {
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(3))
			     .until(ExpectedConditions.presenceOfElementLocated(By.id("forgot_password_link")));
		ForgotPasswordA forgotpasswordA = new ForgotPasswordA(driver);
		
		forgotpasswordA.clickForgotPasswordlink();
		LoginPage login = new LoginPage(driver);
		Thread.sleep(2000);
		forgotpasswordA.enterUsername(readPropertyData("username"));
		forgotpasswordA.clickContinue();
		Thread.sleep(2000);
		String actual = getcurrentUrl();
		String expected = readPropertyData("urlactualTC04A");
		Assert.assertEquals(actual, expected);
		
		
	}
	@Test
	public static void forgotPasswardTC04B() throws InterruptedException, IOException {
		
		ForgotPasswordB forgotpasswordB = new ForgotPasswordB(driver);
		
		LoginPage login = new LoginPage(driver);
		login.Login("123", "2232");
		
		String actual = forgotpasswordB.getErrorMessage();
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(actual, expected);
	
}}
	
				

	


package com.salesforce.pages.base;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.autimationscript.utility.CommonUtilities;
import com.salesforce.autimationscript.utility.GenerateReports;
import com.salesforce.baseclass.BaseTest;

public class BasePage extends CommonUtilities{
	public static WebDriver driver;
	public static Logger logger= LogManager.getLogger(BaseTest.class);
	 public static GenerateReports report= null;
	
public BasePage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		report = GenerateReports.getInstance();
	}



public static void enterText(WebElement element,String text,  String objName) throws IOException, InterruptedException{
	if (element.isDisplayed()) {
		clearElement(element,  objName);
		Thread.sleep(2000);
		element.sendKeys(text);
		logger.info("text entered in " + objName + " field");
		report.logTestInfo("text entered in " + objName + " field");}
	else {	
		logger.error("fail " + objName + " element is not displayed");
		report.logTesFail("fail " + objName + " element is not displayed");}}

	public static void clearElement(WebElement element,  String objName) throws IOException{
		if (element.isDisplayed()) {
			element.clear();
	
			logger.info("text box " + objName + " cleared");
			report.logTestInfo("text box " + objName + " cleared");}
		else {	
		logger.error("fail " + objName + " element is not displayed");
			report.logTesFail("fail " + objName + " element is not displayed");}
	}
	
	public static void waitUntilPagesLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
	}
	public static void navigatingToUsername() throws IOException, InterruptedException {
		WebElement searchElement1 = driver.findElement(By.id("userNav"));
		String actual = searchElement1.getText();

		WebElement searchElement2 = driver.findElement(By.id("userNav-arrow"));	
		clickElement(searchElement2, "user menu");
	}	
	
	public static void clickAccounts() throws IOException, InterruptedException {
 		 WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		  clickElement(searchElement, "Accounts");
		
		  
		 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		 executor1.executeScript("arguments[0].click();", searchElement1);
		 
 		
 	}
	public static void clickOpportunities() throws IOException, InterruptedException {
 		 WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		  clickElement(searchElement, "Opportunities");
		
		  
		 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		 executor1.executeScript("arguments[0].click();", searchElement1);
		 
 		
 	}
	
	public static void clickLead() throws IOException, InterruptedException {
		
		WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
	 	  clickElement(searchElement, "Lead Tab");
	 	 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
 			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
 			 executor1.executeScript("arguments[0].click();", searchElement1);
	}


		
	
	public static void clickElement(WebElement element,  String objName) throws IOException, InterruptedException{
		Thread.sleep(2000);
		
		if (element.isDisplayed()) {
			Thread.sleep(2000);
			element.click();
			logger.info(objName + " clicked");
			report.logTestInfo(objName + " clicked");}
		else {	
		logger.error("fail" + objName + "element is not displayed");
			report.logTesFail("fail" + objName + "element is not displayed");}
		}
	public static WebDriver getDriverInstance() {
		return driver;
	}
	
	
	 public static String getcurrentUrl() {
		 String currenturl= driver.getCurrentUrl();
		 logger.info(currenturl);
		 report.logTestInfo(currenturl);
		 return currenturl;
	 }
	 
	 
	 
	 
	public static void gotoUrl(String url) {driver.get(url);}
		
		 
	
	public static String getTitle() {
		String pagetitle = driver.getTitle();
		logger.info(pagetitle);
		report.logTestInfo(pagetitle);
		return pagetitle;
		
	}
	
	public static void scrollDown() {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		  j.executeScript("window.scrollBy(0,500)");}
	
	public static void scrollUp() {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		  j.executeScript("window.scrollBy(0,-500)");}
	
	
	public static void compareResult(String expected , String actual) {
	String actual1= actual;
	System.out.println(actual);
	String expected1 = expected;
	boolean b1 = actual1.equals(expected1);
	System.out.println(b1);
			if (b1 == true) {
				System.out.println("test case passed");
				report.logTesPassed("test case passed");
			}
			else {System.out.println("test case failed");
					report.logTesFail("test case failed");}}
	
	public static void logoutSalesforce() throws IOException, InterruptedException {
		
		 WebElement searchElement4 = driver.findElement(By.id("userNav-arrow"));	
			clickElement(searchElement4, "user menu");
	      
	      Thread.sleep(3000);
	      
	      WebElement searchElement5 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			clickElement(searchElement5, "Logout");	
	}
			
			
	
	public static void refreshBrowser() {driver.navigate().refresh();}
		
	
	
	public static void closeBrowser() {driver.close();}
		
		
	
	public static void closeAllbrowser() {driver.quit();}
		
	
	

}

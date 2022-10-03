package com.salesforce.baseclass;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

//import com.beust.jcommander.Parameter;
//import com.beust.jcommander.Parameters;
import com.salesforce.autimationscript.utility.CommonUtilities;
import com.salesforce.autimationscript.utility.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends CommonUtilities{
	
	//CommonUtilities cu = new CommonUtilities();
	 public static WebDriver driver = null;
	 public static Logger logger= LogManager.getLogger(BaseTest.class);
	 public static GenerateReports report= null;
	
	 @BeforeTest
	 public static void setUpBeforeTest() {
		 report= report.getInstance();
		 report.startExtentReport();
	 }
	 
	 @Parameters ({"browsername"})
	@BeforeMethod
	public static void setup(String browsername, Method m) throws IOException {
		System.out.println(browsername);
		report.startSigleTestReport(m.getName());
		initialActivity( browsername);}
	
	
	@AfterMethod
	public static void tearDown() {
		closeBrowser();}
	
	@AfterTest
	public static void teardownAfterTest() {
	    report.close();
	}
	
    

	public static void getDriver(String browser) {
		logger.debug("start get driver");
		report.logTestInfo("start get driver");
		
		
		switch (browser) {
		case "chrome":
		WebDriverManager.chromedriver().setup();
		//System.out.println("creating new driver for" + browser);
		driver = new ChromeDriver();
			break;
			
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
			break;
			
		case "edge" :
			WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
			break;
			default: break;}}
	
	public static void initialActivity(String browsername) throws IOException {
		getDriver(browsername);
	 	gotoUrl(readPropertyData("url"));
	 	driver.manage().window().maximize();
	 	waitUntilPagesLoads();}
	
	
	
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
				report.logTesFail("fail " + objName + " element is not displayed");}}
			
		public static void waitUntilPagesLoads() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		
		
		
		
		public static void validLogin() throws IOException, InterruptedException {
			WebElement searchElement = driver.findElement(By.id("username"));
			enterText(searchElement, readPropertyData("username"), "user name");
			WebElement searchElement1 = driver.findElement(By.id("password"));
			enterText(searchElement1, readPropertyData("password"), "password");
			WebElement searchElement2 = driver.findElement(By.id("Login"));
			clickElement(searchElement2, "Login button");
			waitUntilPagesLoads();}
		
		public static void navigatingToUsername() throws IOException, InterruptedException {
			WebElement searchElement1 = driver.findElement(By.id("userNav"));
			String actual = searchElement1.getText();

			WebElement searchElement2 = driver.findElement(By.id("userNav-arrow"));	
			clickElement(searchElement2, "user menu");
		}	
		
		public static void clickContact() throws IOException, InterruptedException {
			WebElement searchElement = driver.findElement(By.id("Contact_Tab"));
 			clickElement(searchElement, "contact");
 			
 			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
 			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
 			 executor1.executeScript("arguments[0].click();", searchElement1);
			 
	 		
	 	}
		public static void createNew() throws IOException, InterruptedException {
			
			WebElement searchElement = driver.findElement(By.id("createNewButton"));
		 	  clickElement(searchElement, "create new");
		 	  
		}
		
		public static void clickHome() throws IOException, InterruptedException {
			
			WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
			  clickElement(searchElement, "Home");
			  
			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				 executor1.executeScript("arguments[0].click();", searchElement1);
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
				report.logTesFail("fail" + objName + "element is not displayed");}}
		
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

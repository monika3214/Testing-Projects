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
	public static void tearDown() {closeBrowser();}
	
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
	
	
	
	public static void waitUntilPagesLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));}
	
	public static void gotoUrl(String url) {driver.get(url);}
	
	public static void closeBrowser() {driver.close();}
	
	 public static String getcurrentUrl() {
		 String currenturl= driver.getCurrentUrl();
		 logger.info(currenturl);
		 report.logTestInfo(currenturl);
		 return currenturl;
	 }
		
		
		
	/*	public static void validLogin() throws IOException, InterruptedException {
			WebElement searchElement = driver.findElement(By.id("username"));
			enterText(searchElement, readPropertyData("username"), "user name");
			WebElement searchElement1 = driver.findElement(By.id("password"));
			enterText(searchElement1, readPropertyData("password"), "password");
			WebElement searchElement2 = driver.findElement(By.id("Login"));
			clickElement(searchElement2, "Login button");
			waitUntilPagesLoads();}
		*/
		
		
		
		
		

	

}

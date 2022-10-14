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

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;


public class AutomationScript extends BaseTest {
	CommonUtilities cu = new CommonUtilities();
	
	@Test
	public static void loginErrorMessageTC01() throws InterruptedException, IOException {
			 	
			 	WebElement searchElement = driver.findElement(By.id("username"));
			 	enterText(searchElement, readPropertyData("username"), "user name");
			 	WebElement searchElement2 = driver.findElement(By.id("Login"));
			 	clickElement(searchElement2, "Login button");
			 	WebElement searchElement3 =driver.findElement(By.id("error"));
			 	
			 	String actual = searchElement3.getText();
			 	String expected = readPropertyData("errormessageactualTC01");
			 	Assert.assertEquals(actual, expected);
				}
	@Test
	public static void loginToSalesForceTC02() throws InterruptedException, IOException {
			    validLogin();
			    Thread.sleep(2000);
			    String actual = getTitle();
			    String expected = readPropertyData("actualTC02");
			    Assert.assertEquals(actual, expected);}
			   
	@Test
		public static void checkRememberMeTC03() throws InterruptedException, IOException {		
				
				WebElement searchElement = driver.findElement(By.id("username"));
				enterText(searchElement, readPropertyData("username"), "user name");
				WebElement searchElement1 = driver.findElement(By.id("password"));
				enterText(searchElement1, readPropertyData("password"), "password");
				WebElement searchElement3 = driver.findElement(By.id("rememberUn"));
				clickElement(searchElement3, "checkbox");
				WebElement searchElement2 = driver.findElement(By.id("Login"));
				clickElement(searchElement2, "Login button");
				System.out.println("clicking profile menu option");
				WebElement searchElement4 = driver.findElement(By.cssSelector("#userNavButton"));	
				clickElement(searchElement4, "user menu");
				//WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
					    // .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"userNav-menuItems\\\"]/a[5]")));
					
				WebElement searchElement5 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
				clickElement(searchElement5, "Logout");	
				Thread.sleep(2000);
				//compareResult(getTitle(),readPropertyData() );
				String actual = getTitle();
				String expected = readPropertyData("pageactualTC03");
				Assert.assertEquals(actual, expected);
	}
				
		@Test						
	public static void forgotPasswardTC04A() throws InterruptedException, IOException {
				
				WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(3))
				     .until(ExpectedConditions.presenceOfElementLocated(By.id("forgot_password_link")));
				
				WebElement searchElement = driver.findElement(By.id("forgot_password_link"));
				clickElement(searchElement, "forgot_password_link");				
				WebElement searchElement1 = driver.findElement(By.id("un"));
				enterText(searchElement1, readPropertyData("username"), "user name");				
				WebElement searchElement2 = driver.findElement(By.id("continue"));
				clickElement(searchElement2, "continue");			
				//compareResult(getcurrentUrl(),readPropertyData("urlactualTC04A") );
				String actual = getcurrentUrl();
				String expected = readPropertyData("urlactualTC04A");
				Assert.assertEquals(actual, expected);
				}
			@Test				
		public static void forgotPasswardTC04B() throws InterruptedException, IOException {
				
				WebElement searchElement = driver.findElement(By.id("username"));
				enterText(searchElement, "123", "user name");
				WebElement searchElement1 = driver.findElement(By.id("password"));
				enterText(searchElement1, "22131", "password");
				WebElement searchElement2 = driver.findElement(By.id("Login"));
				clickElement(searchElement2, "Login");
				//compareResult(getcurrentUrl(),readPropertyData() );
				String actual = getcurrentUrl();
				String expected = readPropertyData("urlactualTC04B");
				Assert.assertEquals(actual, expected);
				}
				@Test					
			public static void selectUsermenuDropdownTC05() throws IOException, InterruptedException {
				String expected = "Monika kindness";
				String expected1 = "My Profile";
				String expected2 = "My Settings";
				String expected3 = "Developer Console";
				String expected4 = "Switch to Lightning Experience";
				String expected5 = "Logout";
		
				
				validLogin();
				WebElement searchElement1 = driver.findElement(By.id("userNav"));
				String actual = searchElement1.getText();
				System.out.println(actual);
	    
				WebElement searchElement2 = driver.findElement(By.id("userNav-arrow"));	
				clickElement(searchElement2, "user menu");
		
				WebElement searchElement3 = driver.findElement(By.linkText("My Profile"));
				String actual1 = searchElement3.getText();
				System.out.println(actual1);
		    
				WebElement searchElement4 = driver.findElement(By.linkText("My Settings"));
				String actual2 = searchElement4.getText();
				System.out.println(actual2);
		    
				WebElement searchElement5 = driver.findElement(By.linkText("Developer Console"));
				String actual3 = searchElement5.getText();
				System.out.println(actual3);
		    
				WebElement searchElement6 = driver.findElement(By.linkText("Switch to Lightning Experience"));
				String actual4 = searchElement6.getText();
				System.out.println(actual4);
		    
				WebElement searchElement7 = driver.findElement(By.linkText("Logout"));
				String actual5 = searchElement7.getText();
				System.out.println(actual5);
		    
				if (actual.equals(expected)&& actual1.equals(expected1)&& actual2.equals(expected2)&& actual3.equals(expected3)&& actual4.equals(expected4)&&actual5.equals(expected5)) {
		    	System.out.println("test case selectUsermenuDropdownTC05 pass ");
				}
				else {
		    	System.out.println("test case selectUsermenuDropdownTC05 fail ");
		    	
				}
				
				}
		    @Test
				public static void selectMyprofileTC06() throws IOException, InterruptedException {
			 		
			 		
			 		String expected = "Monika kindness";
			 		
					validLogin();
					//waitUntilPresenceof(cssSelector("#userNavLabel"),
					
					 WebElement myDynamicElement = 
					(new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userNavLabel")));
						 
					WebElement searchElement1 = driver.findElement(By.cssSelector("#userNavLabel"));
					String actual = searchElement1.getText();
					System.out.println(actual);
					if (actual.equals(expected)){System.out.println("selectMyprofileTC06 step no.1 passed");}
					
					WebElement searchElement2 = driver.findElement(By.id("userNav-arrow"));	
					clickElement(searchElement2, "user menu");
					
					WebElement searchElement3 = driver.findElement(By.linkText("My Profile"));
					 clickElement(searchElement3, "My Profile");
					 Thread.sleep(3000);
					 
					 
					 ////Edit profile starts///
					 WebElement searchElement4 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]"));
					 clickElement(searchElement4, "Edit Profile");
					// WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(20))
					 //.until(ExpectedConditions.presenceOfElementLocated(By.id("aboutTab")));
					 Thread.sleep(3000);
					 driver.switchTo().frame("contactInfoContentId");
					 
					 WebElement searchElement5 = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
				
					 clickElement(searchElement5, "About");
					 
					 WebElement searchElement6 = driver.findElement(By.id("lastName"));
					 enterText(searchElement6, "kindness", "last name textbox" );
					 
					 WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
					 clickElement(searchElement7, "save all button");
					String expectedTitle = "Monika kindness";
					 //searchElement8 is changed page name
					// WebElement searchElement8 = driver.findElement(By.xpath("//*[@id=\"tailBreadcrumbNode\"]"));
					// compareResult(expectedTitle, searchElement8.getText());
					 
					//System.out.println(searchElement8.getText());
					////Edit profile ends////
					
					
					 
					 
					
					 /////Post link starts////
					
					// WebElement myDynamicElement = 
					//(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"publisherAttachTextPost\\\"]/span[1]")));
			 
					 WebElement searchElement9 = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
					 clickElement(searchElement9, "post link ");
					
					 WebElement searchElement10 = driver.findElement(By.xpath("//*[@id=\"cke_43_contents\"]/iframe"));
					 driver.switchTo().frame(searchElement10);
					 WebElement searchElement11 = driver.findElement(By.xpath("/html/body"));
					
					 clickElement(searchElement11, "post text");
					enterText(searchElement11, "hi, good morning there", "post text");
					
					Thread.sleep(3000);
					// WebElement myDynamicElement1 = 
					 //(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("usrUTils"))); 
					driver.switchTo().defaultContent();
					 
					 WebElement searchElement12 = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
					 clickElement(searchElement12, "share button");
					 /////post link ends ////
					 
					 //////file link starts ////
					 WebElement searchElement13 = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]"));
					 clickElement(searchElement13, "file link ");
					 WebElement searchElement14 = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
					 clickElement(searchElement14, "upload file from your computer ");
					// Thread.sleep(5000);
					 WebElement myDynamicElement1 = 
					 (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#chatterFile"))); 
					 //searchElement15 is choose file button.
					 WebElement searchElement15 = driver.findElement(By.cssSelector("#chatterFile"));
					 searchElement15.sendKeys("C:\\Users\\mkuma\\OneDrive\\Desktop\\New folder\\test.txt");
					 WebElement searchElement16 = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
					 clickElement(searchElement16, "share button");
					 ///// file link ends /////
					 
					 refreshBrowser();
					 
					 WebElement searchElement17 = driver.findElement(By.id("displayBadge"));
					 System.out.println("displayBadge");
					 Thread.sleep(6000);
					 Actions action= new Actions(driver);
					 action.moveToElement(searchElement17).perform();
					 System.out.println("mousehover");
					 WebElement searchElement18 = driver.findElement(By.id("uploadLink"));
					 clickElement(searchElement18, "upload image link ");
					 Thread.sleep(3000);
					 driver.switchTo().frame("uploadPhotoContentId");
					 //Chose file
					 WebElement searchElement19 = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
					 searchElement19.sendKeys("C:\\saved pics\\flower1.jpg");
					 System.out.println("file chosen");
					// Thread.sleep(6000);
					 WebElement myDynamicElement2 = 
					(new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.id("j_id0:uploadFileForm:uploadBtn"))); 
							 //searchElement15 is choose file button.
					 //save button
					 WebElement searchElement20 = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
					 JavascriptExecutor executor = (JavascriptExecutor)driver;
					 executor.executeScript("arguments[0].click();", searchElement20);
					 System.out.println("save button clicked");
					 
					// Thread.sleep(5000);
					 WebElement myDynamicElement3 = 
								(new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='j_id0:j_id7:save']")));
					 
					 WebElement searchElement21 = driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
					 
					 JavascriptExecutor executor1 = (JavascriptExecutor)driver;
					 executor1.executeScript("arguments[0].click();", searchElement21);
					 System.out.println("save button from browser frame");
					 //clickElement(searchElement21, "save button from browser");
					 System.out.println("done");
					
				 
			 	} 
			
		 
	 	@Test
	 	
	 	public static void selectMySettingTC07() throws IOException, InterruptedException {
	 		
	 			validLogin();
			  Thread.sleep(6000); 
			  navigatingToUsername();
			  
			  WebElement searchElement4 = driver.findElement(By.linkText("My Settings"));
			  clickElement(searchElement4, "My Settings ");
			  //////Login History starts  ///////
			 WebElement searchElement5 =driver.findElement(By.id("PersonalInfo_font")); 
			 clickElement((searchElement5),"Personal info");
			  
			  WebElement searchElement6 = driver.findElement(By.id("LoginHistory_font"));
			  clickElement(searchElement6, "Login history ");
			  
			  WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
			  clickElement(searchElement7, "download Login history "); 
			  //////Login History ends ///////
			 // WebElement searchElement8 = driver.findElement(By.id("DisplayAndLayout_font")); 
				// clickElement((searchElement8),"Display and Layout");*/
			 
				 
				 WebElement searchElement9 = driver.findElement(By.id("EmailSetup_font")); 
				 clickElement((searchElement9),"Email");
			
				 WebElement searchElement10 = driver.findElement(By.id("EmailSettings_font")); 
				 clickElement((searchElement10),"Email Setting");
				 WebElement searchElement11 = driver.findElement(By.xpath("//input[@name='save']")); 
				 clickElement((searchElement11),"save");
				 
				 WebElement searchElement12 = driver.findElement(By.id("meSaveCompleteMessage")); 
				 String str = searchElement12.getText();
				 System.out.println(str);
				 
				 WebElement searchElement13 = driver.findElement(By.id("CalendarAndReminders_font")); 
				 clickElement((searchElement13),"Calendar And Reminders");
				
				 WebElement searchElement14 = driver.findElement(By.id("Reminders_font")); 
				 clickElement((searchElement14),"Activity Reminders");
				 
				 WebElement searchElement15 = driver.findElement(By.id("testbtn")); 
				 clickElement((searchElement15),"Open a Test Reminder");}
				 
				 
				 
				 
		@Test
	 	public static void selectDevelopersConsoleTC08() throws IOException, InterruptedException {
 			
	 		validLogin();
 			 String str1 = driver.getWindowHandle();
		  Thread.sleep(6000); 
		  navigatingToUsername();
		  
		  WebElement searchElement = driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
		  clickElement(searchElement, "Developers console");
		 
		  
		  Thread.sleep(6000); 
		  
		  
		  Set<String> allWindowhandler = driver.getWindowHandles();
		  for(String handle :allWindowhandler) {
			  if (!str1.equals(allWindowhandler)) {
				  driver.switchTo().window(handle);
				  System.out.println("i m here");
				  break;}
			 }
			  
		  Thread.sleep(6000); 
		  
		  driver.close();
		 
		  
		 // String str2 = driver.getWindowHandle();
		  //System.out.println(str2); 
		  driver.quit();
	 
	 	} 
		
		@Test
	 	public static void selectLogoutTC09(String browsername) throws IOException, InterruptedException {
	 		 
 			validLogin();
		  Thread.sleep(6000); 
		  navigatingToUsername();
		  
		  WebElement searchElement = driver.findElement(By.xpath("//a[@title='Logout']"));
		  clickElement(searchElement, "Logout");
	 
	 
		} 
	 	
	 	@Test
	 	public static void creatAccountTC10() throws IOException, InterruptedException{
	 		
 			validLogin();
 			clickAccounts();
 			 WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
 			  clickElement(searchElement, "Accounts");
 			
 			  
 			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
 			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			 executor1.executeScript("arguments[0].click();", searchElement1);
			 
			 WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
			  clickElement(searchElement2, " New Accounts");
			  
			  WebElement searchElement3 = driver.findElement(By.id("acc2"));
			  enterText(searchElement3,"rose","Account name" );
			  
			  Select se = new Select(driver.findElement(By.id("acc6")));
			  se.selectByValue("Technology Partner");
			  
			  scrollDown();
			  
			  Select se1 = new Select(driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > form:nth-child(6) > div:nth-child(5) > div:nth-child(2) > div:nth-child(7) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1) > select:nth-child(1)")));
			  se1.selectByVisibleText("High");
			  
			  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			  clickElement(searchElement4, " save");}
	 	
	 	@Test
	 	public static void creatNewviewTC11() throws IOException, InterruptedException{
	 		
 			validLogin();
 			clickAccounts();
 			
 			 WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
			  clickElement(searchElement, " create new view");
			  
			  WebElement searchElement1 = driver.findElement(By.id("fname"));
			  enterText(searchElement1,"my view","view name" );
			  
			  WebElement searchElement2 = driver.findElement(By.id("devname"));
			  enterText(searchElement2,"my_view","unique view name" );
			  scrollDown();
			  WebElement searchElement3 = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
			  clickElement(searchElement3, " save");}
			  
		@Test
	 	public static void editViewTC12() throws IOException, InterruptedException{
	 		
 			validLogin();
 			clickAccounts();
 			
 			Select se = new Select(driver.findElement(By.id("fcf")));
			  se.selectByValue("00B4x00000GlRxE");
			  Thread.sleep(3000);
			  
			  WebElement searchElement = driver.findElement(By.linkText("Edit"));
			  clickElement(searchElement, " Edit");
			  
			  WebElement searchElement1 = driver.findElement(By.id("fname"));
			  enterText(searchElement1,"my new Account","view name" );
			  
			  WebElement searchElement2 = driver.findElement(By.id("devname"));
			  enterText(searchElement2,"mynew_Account","unique view name" );
			  
			  Select se1 = new Select(driver.findElement(By.id("fcol1")));
			  se1.selectByValue("ACCOUNT.NAME");
			  
			  Select se2 = new Select(driver.findElement(By.id("fop1")));
			  se2.selectByValue("c");
			  
			  WebElement searchElement3 = driver.findElement(By.id("fval1"));
			  enterText(searchElement3,"a","value" );
			  
			  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
			  clickElement(searchElement4, " save");}
			  
			@Test
	 	public static void mergeAccountTC13() throws IOException, InterruptedException{
	 		
 			validLogin();
 			clickAccounts();
 			WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
			  clickElement(searchElement, " Merge Account");
			  
			  WebElement searchElement1 = driver.findElement(By.id("srch"));
			  enterText(searchElement1,"a1","accounts to merge" );
			  Thread.sleep(8000);
			  WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
			  clickElement(searchElement2, " Find Accounts");
			  Thread.sleep(8000);
			  WebElement searchElement3 = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
			  clickElement(searchElement3, "next");
			  Thread.sleep(15000);
			  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
			  clickElement(searchElement4, "merge");
			  
			  Thread.sleep(15000);
			  String str1 = driver.getWindowHandle();
			  Set<String> allWindowhandler = driver.getWindowHandles();
			  for(String handle :allWindowhandler) {
				  if (!str1.equals(allWindowhandler)) {
					Alert str2 =  (Alert) driver.switchTo().window(handle);
					str2.accept();
					 // System.out.println("i m here");
					  //driver.close();
					  //break;}
				  Thread.sleep(8000);
				  //driver.close();
				 }}
	 	
	 	
	 	}
			  //driver.switchTo().alert().accept();}
		
			@Test
	 	public static void creatAccountReportTC14() throws IOException, InterruptedException{
	 		
 			validLogin();
 		// WebElement myDynamicElement1 = 
		//	new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("usrUTils"))); 
 			Thread.sleep(6000);
 			clickAccounts();
 			
 			WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
			  clickElement(searchElement1, "Account with last activity >30 days");
	 		
	 	  WebElement searchElement2 = driver.findElement(By.id("ext-gen152"));
	 	  clickElement(searchElement2, "from calendar button");
	 	 Thread.sleep(3000);
	 	 WebElement searchElement3 = driver.findElement(By.cssSelector("#ext-gen277"));
	 	  clickElement(searchElement3, "from calendar Today button");
	 	 Thread.sleep(3000);
	 	 WebElement searchElement4 = driver.findElement(By.id("ext-gen154"));
	 	  clickElement(searchElement4, "to calendar Today button");
	 	 Thread.sleep(3000);
	 	 WebElement searchElement5 = driver.findElement(By.cssSelector("#ext-gen294"));
	 	  clickElement(searchElement5, "to calendar Today button");
	 	  
	 	 Thread.sleep(3000);
	 	 WebElement searchElement6 = driver.findElement(By.xpath("//*[@id=\"ext-gen49\"]"));
	 	  clickElement(searchElement6, " save");
	 	  
	 	}
	 	
			@Test
			public static void opportunitiesDropDownTC15() throws IOException, InterruptedException{
		 		
	 			validLogin();
	 			clickOpportunities();
	 			/*WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
	 		 	  clickElement(searchElement, "Opportunities");
	 		 	  
	 		 	 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
	 			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	 			 executor1.executeScript("arguments[0].click();", searchElement1);*/
	 			 
	 			 Select se = new Select(driver.findElement(By.xpath("//*[@id=\"fcf\"]")));
				 
				  List <WebElement> op = se.getOptions();
			      int size = op.size();
			     // String actual ;
			      for(int i =0; i<size ; i++){
			        String options = op.get(i).getText();
			        System.out.println(options);}
			        }
			    // String actual = op.get(i).getText();}
			    //     System.out.println(actual);}
			    /*  for(int i =0; i<size ; i++){
			    	  System.out.println(actual[i]);
			      }*/
				 
		 	
			@Test
		 	public static void createNewOptyTC16() throws IOException, InterruptedException{
		 		
	 			validLogin();
	 			clickOpportunities();
	 			WebElement searchElement = driver.findElement(By.id("createNewButton"));
			 	  clickElement(searchElement, "create new");
			 	  
			 	 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[4]"));
			 	  clickElement(searchElement1, "click Opportunities");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.id("opp3"));
				  enterText(searchElement2,"opty1","opportunity name" );
			 	  
				  WebElement searchElement3 = driver.findElement(By.id("opp4"));
				  enterText(searchElement3,"Account1","Account name" );
				  
				  WebElement searchElement4 = driver.findElement(By.id("opp9"));
			 	  clickElement(searchElement4, "closing date");
			 	  
			 	 WebElement searchElement5 = driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[2]/div/a"));
			 	  clickElement(searchElement5, "Today");
			 	  //lead source///
			 	 Select se1 = new Select(driver.findElement(By.id("opp6")));
				  se1.selectByValue("Web");
				  
				  //stage///
				  Select se2 = new Select(driver.findElement(By.cssSelector("#opp11")));
				 se2.selectByVisibleText("Prospecting");
			 	  
			 	  
			 	 WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			 	 clickElement(searchElement7, "save");
			 	
			 	
				  
	 			}
				@Test
		 	public static void testOpportunityPipelineReportTC17() throws IOException, InterruptedException{
		 		
	 			validLogin();
	 			clickOpportunities();
	 			WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
			 	  clickElement(searchElement4, "opportunity pipeline");
			 	  
			 	  String str1 = getTitle();
			 	  System.out.println(str1);
	 			
		 	}
				@Test
		 	public static void testStuckOpportunitiesReportTC18() throws IOException, InterruptedException{
		 		
	 			validLogin();
	 			clickOpportunities();
	 			WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
			 	  clickElement(searchElement4, "Stuck opportunity");
			 	  
			 	  String str1 = getTitle();
			 	  System.out.println(str1);
	 			}
				@Test
		 	public static void testQuarterlySummaryReportTC19() throws IOException, InterruptedException{
		 		
	 			validLogin();
	 			clickOpportunities();
	 			//lead source///
			 	 Select se1 = new Select(driver.findElement(By.id("quarter_q")));
				  se1.selectByValue("current");
				  
				  //stage///
				  Select se2 = new Select(driver.findElement(By.id("open")));
				 se2.selectByVisibleText("Open Opportunities");
				  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
			 	  clickElement(searchElement4, "Run Report");
			 	 String str1 = getTitle();}
		 	@Test
		 	public static void leadTabTC20() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickLead();
	 			logoutSalesforce();}
		 	@Test
		 	public static void leadsSelectViewTC21() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickLead();
	 			WebElement searchElement2 = driver.findElement(By.cssSelector("#fcf"));
			 	  clickElement(searchElement2, "My Unread Lead ");
		 	  
		 	  
		 	 Select se = new Select(driver.findElement(By.id("fcf")));
			 
			  List <WebElement> op = se.getOptions();
		      int size = op.size();
		     // String actual ;
		      for(int i =0; i<size ; i++){
		        String options = op.get(i).getText();
		        System.out.println(options);}}
		 	
		 	@Test
		 	public static void defaultViewTC22() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			Thread.sleep(3000);
	 			clickLead();
	 			 Select se1 = new Select(driver.findElement(By.id("fcf")));
				 se1.selectByVisibleText("Today's Leads");
				 logoutSalesforce();
				 Thread.sleep(3000);
				 validLogin();
				 Thread.sleep(3000);
				 WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
			 	  clickElement(searchElement, "Lead Tab");
				 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
			 	  clickElement(searchElement1, "Go");
			 	  getTitle();
				 
				 
				 
		 	
		 	
		 	}
		 	@Test
		 	public static void todaysLeadTC23() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickLead();
	 			Select se1 = new Select(driver.findElement(By.id("fcf")));
				 se1.selectByVisibleText("Today's Leads");
				 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
			 	  clickElement(searchElement1, "Go");
			 	  getTitle();
	 			
		 	}
		 	
		 	@Test
		 	public static void newOnleadHomeTC24() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickLead();
	 			WebElement searchElement = driver.findElement(By.id("createNewButton"));
			 	  clickElement(searchElement, "create new");
			 	  
			 	 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[5]"));
			 	  clickElement(searchElement1, "click lead");
			 	 WebElement searchElement2 = driver.findElement(By.id("name_lastlea2"));
				  enterText(searchElement2,"abcd","Last name" );
			 	  
				  WebElement searchElement3 = driver.findElement(By.id("lea3"));
				  enterText(searchElement3,"abcd","Account name" );
				  WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
				 	 clickElement(searchElement7, "save");
				 	 getTitle();
				  
		 	
		 	}
		 	@Test
			public static void creatNewContactTC25() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickContact();
	 			createNew();
	 			
			 	 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[3]"));
			 	  clickElement(searchElement1, "contact");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.id("name_lastcon2"));
				  enterText(searchElement2,"rose","Last name" );
				  
				  WebElement searchElement3 = driver.findElement(By.xpath("//*[@id=\"con4_lkwgt\"]/img"));
			 	  clickElement(searchElement3, "click magnifyingGlass button");
			 	 
			 	/*  driver.switchTo().frame("searchFrame");
			 	 WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"new\"]/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a"));
			 	  clickElement(searchElement4, "choose account");*/
			 	  
			 	 WebElement searchElement5 = driver.findElement(By.id("con4"));
				  enterText(searchElement5,"a1care","Account name" );
				  
				  scrollDown();
				  
				  WebElement searchElement6 = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			 	  clickElement(searchElement6, "save");}
			 	  
			
	 			@Test
		 	public static void newViewContactTC26() throws IOException, InterruptedException {
		 		
	 			
	 			validLogin();
	 			clickContact();
	 			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
			 	  clickElement(searchElement1, "New View");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.id("fname"));
				  enterText(searchElement2,"new view2","View name" );
				  
				  WebElement searchElement3 = driver.findElement(By.id("devname"));
				  enterText(searchElement3,"","View name" );
				  
				  WebElement searchElement6 = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
			 	  clickElement(searchElement6, "save");
	 			
	 			}
	 			
	 			@Test
		 	public static void checkRecentlyCreatedContactTC27() throws IOException, InterruptedException {
		 		
	 			
	 			validLogin(); 
	 			clickContact();
	 			
	 			/* WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"hotlist_mode\"]"));
			 	  clickElement(searchElement, "Recently Created");
			 	  
			 	  Thread.sleep(3000);*/
			 	  
	 			Select se1 = new Select(driver.findElement(By.id("hotlist_mode")));
				 se1.selectByVisibleText("Recently Created");
	 			
	 			
	 			}
	 			
	 			@Test
		 	public static void checkMyContactViewTC28() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickContact();
	 			
	 			Select se1 = new Select(driver.findElement(By.id("fcf")));
				 se1.selectByVisibleText("My Contacts");
	 			}
	 			
	 			@Test
		 	public static void viewaContactinContactPageTC29() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickContact();
	 			 WebElement searchElement6 = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
			 	  clickElement(searchElement6, "name link");
			 	  
			 	 
	 			}
	 			
	 			@Test
		 	public static void checkErrorMessageTC30() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickContact();
	 			WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
			 	  clickElement(searchElement1, "New View");
			 	  
			 	 WebElement searchElement3 = driver.findElement(By.id("devname"));
				  enterText(searchElement3,"abcd","View name" );
				  
				  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
			 	  clickElement(searchElement4, "save");
				
			 	  
	 			
	 			WebElement searchElement5 =driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));
			 	String actual = searchElement5.getText();
			 	String expected = "Error: You must enter a value";
			 	compareResult(actual,expected );
				
	 			}
	 			
	 			@Test
		 	public static void checkCancleButtonTC31() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickContact();
	 			createNew();
	 			
			 	 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[3]"));
			 	  clickElement(searchElement1, "contact");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.id("name_firstcon2"));
				  enterText(searchElement2,"abcd","First name" );
			 	  
			 	 WebElement searchElement3 = driver.findElement(By.id("name_lastcon2"));
				  enterText(searchElement3,"efgh","Last name" );
				  
				  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[3]"));
			 	  clickElement(searchElement4, "cancel");
			 	  getTitle();
				  
				  
	 			}
	 			
	 			@Test
		 	public static void checkSaveandNewButtonTC32() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickContact();
	 			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
			 	  clickElement(searchElement1, "New");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.id("name_firstcon2"));
				  enterText(searchElement2,"abcd","First name" );
			 	 
			 	 WebElement searchElement3 = driver.findElement(By.id("name_lastcon2"));
				  enterText(searchElement3,"Indian","Last name" );
				  
				  WebElement searchElement5 = driver.findElement(By.id("con4"));
				  enterText(searchElement5,"a1latest","First name" );
				  
				  WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[2]"));
			 	  clickElement(searchElement4, "Save & New");
			 	  String expected = "abcd Indian";
			 	 
			 	 WebElement searchElement6 =driver.findElement(By.xpath("//*[@id=\"mru0034x00001IdNo9\"]/a/span"));
				 	String actual = searchElement6.getText();
				 	
				 	compareResult(actual,expected );}
		 	
	 			@Test
		 	public static void firstnameLastnameLinkTC33() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickHome();
	 			
			 	 WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
			 	  clickElement(searchElement2, "Firstname Lastname Link");
			 	  String expected = "User: Monika kindness ~ Salesforce - Developer Edition";
			 	  String actual = getTitle();
			 	 compareResult(actual,expected );
			 	 
		 	}
	 			
	 			@Test
		 	public static void lastNameChangedatVariousPlaceTC34() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickHome();
	 			
			 	 WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
			 	  clickElement(searchElement2, "Firstname Lastname Link");
			 	  
			 	 WebElement searchElement4 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]"));
				 clickElement(searchElement4, "Edit Profile");
				// WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(20))
				 //.until(ExpectedConditions.presenceOfElementLocated(By.id("aboutTab")));
				 Thread.sleep(3000);
				 driver.switchTo().frame("contactInfoContentId");
				 
				 WebElement searchElement5 = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
			
				 clickElement(searchElement5, "About");
				 
				 WebElement searchElement6 = driver.findElement(By.id("lastName"));
				 enterText(searchElement6, "kindness", "last name textbox" );
				 
				 WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
				 clickElement(searchElement7, "save all button");
			 	  
			 	  
		 		
		 	}
	 			@Test
		 	public static void verifyTabCustomizationTC35() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a"));
			 	  clickElement(searchElement1, "Add all tab +");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
			 	  clickElement(searchElement2, "customize my tabs");
			 	  
			 	 Select se1 = new Select(driver.findElement(By.id("duel_select_1")));
				 se1.selectByVisibleText("Chatter");
				 
				 WebElement searchElement3 = driver.findElement(By.xpath("//*[@id=\"duel_select_0_left\"]/img"));
			 	  clickElement(searchElement3, "Remove");
			 	  
			 	 WebElement searchElement4 = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			 	  clickElement(searchElement4, "save");
				 
		 	}
	 			
	 			@Test
		 	public static void blockingEventinCalendarTC36() throws IOException, InterruptedException {
		 		
	 			validLogin();
	 			clickHome();
	 			 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
			 	  clickElement(searchElement1, "current date link");
			 	  
			 	 WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
			 	  clickElement(searchElement2, "current date link");
			 	  
			 	 WebElement searchElement3 = driver.findElement(By.xpath("//*[@id=\"whtbtn\"]/img"));
			 	  clickElement(searchElement3, "'Subject Combo' icon");
			 	  
			 	// WebElement searchElement4 = driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"));
			 	  //clickElement(searchElement4, "'Subject Combo' icon");
			 	  
			 	 WebElement searchElement5 = driver.findElement(By.id("evt5"));
				 enterText(searchElement5, "other", "subject" );
				 
				 //driver.switchTo().frame("contactInfoContentId");
				 WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"EndDateTime_time\"]"));
			 	  clickElement(searchElement7, "End time");
			 	  
				 WebElement searchElement6 = driver.findElement(By.xpath("//*[@id=\"timePickerItem_42\"]"));
				 clickElement(searchElement6, "end time ");
				 
				 WebElement searchElement8 = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
				 clickElement(searchElement8, "save");
			
		 	}
	 			
	 			@Test
		 	public static void blockingEventCalendarWeeklyRecurranceTC37() throws IOException, InterruptedException {
		 	
				validLogin();
				clickHome();
				 WebElement searchElement1 = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		 	  clickElement(searchElement1, "current date link");
		 	  
		 	 WebElement searchElement2 = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a"));
		 	  clickElement(searchElement2, "4:00 PM link");
		 	  
		 	 WebElement searchElement5 = driver.findElement(By.id("evt5"));
			 enterText(searchElement5, "other", "subject" );
			 
			 WebElement searchElement7 = driver.findElement(By.xpath("//*[@id=\"EndDateTime_time\"]"));
		 	  clickElement(searchElement7, "End time");
		 	  
		 	 WebElement searchElement6 = driver.findElement(By.xpath("//*[@id=\"timePickerItem_38\"]"));
			 clickElement(searchElement6, "end time 7 PM ");
			 
			 WebElement searchElement8 = driver.findElement(By.xpath("//*[@id=\"IsRecurrence\"]"));
			 clickElement(searchElement8, "Recurrence");
			 
			 WebElement searchElement9 = driver.findElement(By.id("rectypeftw"));
			 clickElement(searchElement9, "Weekly radiobutton");
			 
			 WebElement searchElement10 = driver.findElement(By.xpath("//*[@id=\"maxRecurrence\"]/span/a"));
			 clickElement(searchElement10, "end date");
			 
			 WebElement searchElement11 = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			 clickElement(searchElement11, "save");
			
			 
			 WebElement searchElement12 = driver.findElement(By.xpath("//*[@id=\"bCalDiv\"]/div/div[2]/span[2]/a[3]/img"));
			 clickElement(searchElement12, "month view");
			 
			 
			 
		 	
			 	  
			 	  
		 	}
	 			}
	 			
	 							
								
				

	


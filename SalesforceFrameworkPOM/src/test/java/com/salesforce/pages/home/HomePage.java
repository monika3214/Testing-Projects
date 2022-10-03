package com.salesforce.pages.home;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class HomePage extends BasePage {
	//user nav menu option
	@FindBy(id="userNav-arrow")WebElement searchElement4;
	//Logout Button
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")WebElement searchElement5; 
	
	
	
	public HomePage(WebDriver driver){
		
		super(driver);
	}
	public String homeTitle() {
		String pagetitle = driver.getTitle();
		return pagetitle;
		
	}
	
	public void clickUserNav() {
		try {
			clickElement(searchElement4, "user nav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickLogout() {
		try {
			clickElement(searchElement5, "Logout");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
/*WebElement searchElement4 = driver.findElement(By.id("userNav-arrow"));	
clickElement(searchElement4, "user menu");
//WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
	    // .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"userNav-menuItems\\\"]/a[5]")));
	
WebElement searchElement5 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
clickElement(searchElement5, "Logout");	*/
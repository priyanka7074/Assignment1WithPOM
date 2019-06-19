package com.zoopla.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zoopla.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Object repository
	
	@FindBy(xpath = "//button[@class='button cookie-banner__button']")
	WebElement acceptBtn;
	
	@FindBy(xpath = "//img[@class='icon--logo']")
	WebElement zooplaLogo;
	
	@FindBy(xpath = "//a[@id='search-tabs-for-sale']")
	WebElement forSaleTab;
	
	@FindBy(id = "search-input-location")
	WebElement destinationName;
	
	@FindBy(id = "search-submit")
	WebElement searchBtn;
	
	
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this); //this means pointing to the current class object
		
		}
	
	
	//Actions: Different Features
	
	public HomePage selectDestination() {
		
		acceptBtn.click();
		zooplaLogo.click();
		Actions action = new Actions(driver);
		action.moveToElement(forSaleTab).build().perform();
		
	    WebElement destName = driver.findElement(By.id("search-input-location"));
	    destName.sendKeys("London");
	    destName.click();
		
		searchBtn.click();
		return new HomePage();
	}
	

}

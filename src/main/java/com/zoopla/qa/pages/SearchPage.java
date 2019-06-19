package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zoopla.qa.base.TestBase;

public class SearchPage extends TestBase {
	
	public String value;
	

	//Object Repository
	@FindBy(xpath = "//div[@class='ui-agent__logo']//img[@class='js-lazy-loaded']")
	WebElement imglogo;
	
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
    WebElement agentName;
	
	@FindBy(xpath = "//div[@class='dp-grid-wrapper']//p/a")
	WebElement phoneNo;
	

	// Initializing the page objects
	public SearchPage() {
		PageFactory.initElements(driver, this); // this means pointing to the current class object

	}
	
	public boolean imgLogoVerify() {
		return imglogo.isDisplayed();	
	}
	
	public boolean agentNameVerify() {
		
		value = agentName.getText();
		System.out.println(value);
		return agentName.isDisplayed();
	}
	
	public boolean agentTelephoneVerify() {
		return phoneNo.isDisplayed();
	}
	
	public AgentPage agentDetailsPage() {
		agentName.click();
		return new AgentPage();
		
	}
	

}

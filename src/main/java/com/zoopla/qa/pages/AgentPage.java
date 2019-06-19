package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class AgentPage extends TestBase {
	
	public String value1;
	
	@FindBy(xpath = "//h1[@class='bottom-half']/b[1]")
	WebElement agentName;
	
	// Initializing the page objects
		public AgentPage() {
			PageFactory.initElements(driver, this); // this means pointing to the current class object

		}
		
		
		public boolean agentDetailsVerify() {
			value1 = agentName.getText();
			System.out.println(value1);
			return agentName.isDisplayed();
		}
	

}

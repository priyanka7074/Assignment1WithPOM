package com.zoopla.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.zoopla.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Object Repository
	@FindBy(xpath = "//li[6]//div[@class='agent_logo']//img")
	WebElement listLogo;

	

	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this); // this means pointing to the current class object

	}

	public void sortPriceValuesDesc() {

		List<WebElement> list = driver.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		System.out.println(list.size());
		

		ArrayList<Integer> p = new ArrayList<Integer>(list.size());

		for (int i = 0; i < list.size(); i++) {
			String linkText = list.get(i).getText();
			String priceWoJunk = linkText.replaceAll("[^0-9]", "");
			System.out.println(priceWoJunk);
			
			try {

			if (priceWoJunk != "POA" || priceWoJunk.trim().length()>0) {
				int price = Integer.parseInt(priceWoJunk);
				p.add(price);
			}
			}catch (NumberFormatException nfe) {
			      System.out.println("Number format exception handled");
		    }
		}

		System.out.println("Original price values: " + p);

		Collections.sort(p, Collections.reverseOrder());

		System.out.println("Sorted Price Values in descending order:");

		for (int num : p) {

			System.out.println(num);
		}
	}

	public SearchPage searchResultsPage() {
		
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		String fifthProp = list.get(4).getText();
		System.out.println(fifthProp);
	    list.get(4).click();
        return new SearchPage();
	}
	
	public void verifyAgentLogo() {
		System.out.println("The image text is: "+listLogo.getAttribute("alt"));
		Boolean b = listLogo.isDisplayed();
		Assert.assertTrue(b);
	
	}

}

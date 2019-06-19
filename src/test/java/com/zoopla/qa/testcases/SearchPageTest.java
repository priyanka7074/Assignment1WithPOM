package com.zoopla.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.AgentPage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.LoginPage;
import com.zoopla.qa.pages.SearchPage;

public class SearchPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	AgentPage agentpage;
	
	public SearchPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		homepage = loginpage.selectDestination();
		searchpage = homepage.searchResultsPage();
	}
	
	@Test(priority = 1)
	public void logoVerifyTest() {
		Assert.assertTrue(searchpage.imgLogoVerify(), "Image Logo is not displayed");
		
	}
	
	@Test(priority = 2)
	public void agentVerifyTest() {
		Assert.assertTrue(searchpage.agentNameVerify(), "Agent Name is not displayed");
		
	}
	
	@Test(priority = 3)
	public void telephoneVerifyTest() {
		Assert.assertTrue(searchpage.agentTelephoneVerify(), "Telephone link is not displayed");
		
	}
	
	@Test(priority = 4)
	public void agentPageTest() {
		agentpage = searchpage.agentDetailsPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

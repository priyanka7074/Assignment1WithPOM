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

public class AgentPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	AgentPage agentpage;
	
	public AgentPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		homepage = loginpage.selectDestination();
		searchpage = homepage.searchResultsPage();
		agentpage = searchpage.agentDetailsPage();
	}
	
	
	@Test
	public void verifyAgentDetailsTest() {
		
		Assert.assertEquals(agentpage.value1,searchpage.value, "Agent details mismatch");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.zoopla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.LoginPage;
import com.zoopla.qa.pages.SearchPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		homepage = loginpage.selectDestination();

	}

	@Test(priority = 1)
	public void selectDestTest() {
		homepage.sortPriceValuesDesc();
	}

	@Test(priority = 3)
	public void selectfifthDest() {
		searchpage = homepage.searchResultsPage();
	}
	
	@Test(priority = 2)
	public void selectfifthLogo() {
		homepage.verifyAgentLogo();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

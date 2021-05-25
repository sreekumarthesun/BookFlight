package com.newtours.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.LoginPage;
import com.newtours.pages.SelectFlightPage;
import com.newtours.utilities.Generic;

public class BookFlight extends Generic {

	public WebDriver driver;

	@DataProvider(name = "userslist")
	public Object[][] usersList() {

		Object[][] data = new Object[2][2];

		data[0][0] = "sree";
		data[0][1] = "kumar";
		data[1][0] = "sree";
		data[1][1] = "charith";
		return data;
	};

	@BeforeTest
	@Parameters({ "browserName", "url" })
	public void launchBrowser(String browserName, String url) throws MalformedURLException {
		driver = Generic.getDriver(browserName, url);

	}

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		String currentTitle = loginPage.loginToDemoaut("sree", "kumar");
		String pageSource = driver.getPageSource();
		if (pageSource.contains("Whitelabel Error")) {
			System.out.println("Login Unsuccessful. Fatal Error");
			driver.quit();

		} else {
			Assert.assertEquals(currentTitle, "Find a Flight: Mercury Tours:");
		}

	}

	@Test(dependsOnMethods = { "login" })
	public void findFlight() {

		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.findFlight();
		String title = findFlightPage.verifySelectFlightTitle();

		Assert.assertEquals(title, "Select a Flight: Mercury Tours");
	}

	@Test
	public void selectFlight() {

		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);

		selectFlightPage.selectFlights();
		String title = selectFlightPage.verifyBookFlightTitle();
		Assert.assertEquals(title, "Book a Flight: Mercury Tours");

	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}

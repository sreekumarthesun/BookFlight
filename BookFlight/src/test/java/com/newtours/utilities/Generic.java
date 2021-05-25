package com.newtours.utilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


public class Generic {

	public static WebDriver getDriver(String browserName, String url) throws MalformedURLException {
		WebDriver driver = null;
		final String CHROMEDRIVERPATH = "/Users/i339884/Desktop/selenium/Selenium/softwares/chromedriver";
		final String FFDRIVERPATH = "/Users/i339884/Desktop/selenium/Selenium/softwares/gecodriver";
		final String IEDRIVERPATH = "/Users/i339884/Desktop/selenium/Selenium/softwares/IEdriver";
		final int IMPLICITWAITSTND = 30;

		try {
			if (browserName.toLowerCase().equals("ie")) {
				System.setProperty("webdriver.ie.driver", IEDRIVERPATH);
				driver = new ChromeDriver();

				Reporter.log("Browser Opened", true);

				driver.manage().timeouts().implicitlyWait(IMPLICITWAITSTND, TimeUnit.SECONDS);
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}

			if (browserName.toLowerCase().equals("ff")) {
				System.setProperty("webdriver.chrome.driver", FFDRIVERPATH);
				driver = new ChromeDriver();

				Reporter.log("Browser Opened", true);

				driver.manage().timeouts().implicitlyWait(IMPLICITWAITSTND, TimeUnit.SECONDS);
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}
			if (browserName.toLowerCase().equals("cr")) {
				System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
				driver = new ChromeDriver();

				Reporter.log("Browser Opened", true);

				driver.manage().timeouts().implicitlyWait(IMPLICITWAITSTND, TimeUnit.SECONDS);
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}
		} catch (Exception e) {
			System.out.println("Error in browser" + e);
		}
		return driver;
	}

}

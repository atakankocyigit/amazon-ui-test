package com.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected Logger log;
	protected WebDriver driver;
	
	@BeforeMethod
	protected void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		log = LogManager.getLogger();
		log.info("Chrome browser is started.");
		driver.manage().window().maximize();
	}
	@AfterMethod
	protected void tearDown() {
		log.info("Chrome driver quit.");
		driver.quit();
	}
}

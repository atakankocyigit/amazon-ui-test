package com.amazon.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected Logger log;
	public BasePage(WebDriver driver, Logger log) {
		this.driver=driver;
		this.log=log;
	}
	
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	protected WebElement find(By locator, int timeout) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected boolean isElementAvailable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}
	
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}
	
	protected void click(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();;
	}
	
	protected void search(By locator, int timeout, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text + Keys.ENTER);;
	}
}

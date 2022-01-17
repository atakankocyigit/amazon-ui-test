package com.amazon.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{
	
	private By deliveryLocator= By.xpath("//a/div/span[@class='a-size-base a-color-base']");
	private By productNameLocator= By.xpath("//a/span[@class='a-size-base-plus a-color-base a-text-normal']");
	
	public ProductPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public boolean isProductFounded() {
		return isElementAvailable(deliveryLocator, 5);
	}
	public ProductDetailsPage selectProduct(int productNumber) {
		log.info("Selected product number: "+ productNumber);
		List<WebElement> productList= findAll(productNameLocator);
		
		if(productList.size() >= productNumber && productNumber > 0)
			findAll(productNameLocator).get(productNumber-1).click();
		else 
			throw new IndexOutOfBoundsException("You choose product: " + productNumber + " but there are  "+ productList.size()+ " products");
		return new ProductDetailsPage(driver, log);
	}
}

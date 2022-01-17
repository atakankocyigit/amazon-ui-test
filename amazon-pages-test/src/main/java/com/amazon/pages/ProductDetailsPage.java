package com.amazon.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

	private By addToCartButtonLocator= By.id("add-to-cart-button");
	private By cartCountLocator= By.id("nav-cart-count");
	private By productTitleLocator= By.id("productTitle");
	private String productName;
	
	public ProductDetailsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public void addToCart() {
		productName= find(productTitleLocator, 5).getText();
		click(addToCartButtonLocator, 5);
	}
	public CartPage clickCartButton() {
		click(cartCountLocator, 5);
		return new CartPage(driver, log);
	}
	public String getProductName() {
		return productName;
	}
}

package com.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDetailsPage;
import com.amazon.pages.ProductPage;

public class AddToCartTest extends BaseTest{
	
	@Test
	public void addToCartTest() {
		
		log.info("Starting add to cart test.");
		HomePage homePageInstance = new HomePage(driver, log);
		homePageInstance.openHomePage();
		
		//Accept cookies.
		log.info("Accept Cookies.");
		homePageInstance.acceptCookie();
		
		//Search product
		String product= "4k ultra tv";
		log.info("Searching item: "+ product);
		ProductPage productPageInstance= homePageInstance.searchProduct(product, 5);
				
		Assert.assertTrue(productPageInstance.isProductFounded(), "Product is not available");
		
		//Select product
		log.info("Select second product.");
		ProductDetailsPage productDetailsPageInstance = productPageInstance.selectProduct(2);
		
		//Add to cart
		log.info("Product is adding to cart.");
		productDetailsPageInstance.addToCart();
		
		log.info("Go to cart page");
		CartPage cartPageInstance= productDetailsPageInstance.clickCartButton();
		
		String actualProductName= cartPageInstance.getCartProductName().toLowerCase();
		String expectedProductName= productDetailsPageInstance.getProductName().toLowerCase();
		
		Assert.assertTrue(actualProductName.contains(expectedProductName), "Actual product name does not contain expected product name. Expected product name: "
		+ expectedProductName + " actual product name: "+ actualProductName);
		
	}
}

package com.build.qa.build.selenium.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.FiltersPage;
import com.build.qa.build.selenium.pageobjects.ProductToCart;



public class BuildTest extends BaseFramework { 
	
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
/*	@Test
	public void navigateToHomePage() { 
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}*/
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @throws InterruptedException 
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 */
	/*@Test
	public void searchForProductLandsOnCorrectProduct() throws InterruptedException { 
		// TODO: Implement this test
		 
		 driver.get(getConfiguration("BATHROOM"));
		 ProductToCart productToCart = new ProductToCart(driver, wait);
		 String actualTitle = productToCart.searchProduct();
		 String expectedTitle="Quoizel MY1613ML";
		 softly.assertThat(actualTitle).isEqualTo(expectedTitle);
		 
	}*/
	
	/** 
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504) 
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws Exception 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	
	
	//Done 
	////*[@data-category-id='108412']/a
	/*@Test
	public void addProductToCartFromCategoryDrop() throws Exception { 
		// TODO: Implement this test
		//*********************************************
		driver.get(getConfiguration("BATHROOM"));
		
		ProductToCart productToCart = new ProductToCart(driver, wait);
		 
		String actualTitle = productToCart.AddProductToCart();
		
		System.out.println("Actual title::" + actualTitle);
		String expectedTitle="Kohler K-2355 Archer 19-5/8\" Undermount Bathroom Sink with Overflow";
		softly.assertThat(actualTitle).isEqualTo(expectedTitle);
		
		
	}*/
	 
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @throws InterruptedException 
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addProductToCartAndEmailIt() throws InterruptedException { 
		driver.get(getConfiguration("BATHROOM"));
		ProductToCart productToCart = new ProductToCart(driver, wait);
		String expectedMessage = productToCart.emailCart();
		
		String actualMessage ="Cart Sent! The cart has been submitted to the recipient via email.";
		softly.assertThat(actualMessage).isEqualTo(expectedMessage);
		
	}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @throws Exception 
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	/*@Test
	public void facetNarrowBysResultInCorrectProductCounts() throws Exception { 
		// TODO: Implement this test
		
		driver.get(getConfiguration("BATHROOM"));
		
		FiltersPage filtersPage = new FiltersPage(driver, wait);
		 
		
	String allCounts =	filtersPage.facetNarrowBysResult();
	
	System.out.println("all counts :::" + allCounts);
		
	String[] allCountsArray = allCounts.split("-");
	
	int actualCount =	Integer.parseInt(allCountsArray[0]);
	int expectedCount =	Integer.parseInt(allCountsArray[1]);
	
	System.out.println("actual Count:::" + actualCount + "Expected Count::" + expectedCount);
	softly.assertThat(actualCount).isEqualTo(expectedCount);
	}*/
}

package com.build.qa.build.selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.build.qa.build.selenium.framework.BaseFramework;

public class FiltersPage extends BaseFramework {
	
	public FiltersPage(WebDriver driver, Wait<WebDriver> wait) { 
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	//First filter
	 @FindBy(xpath="//*[@data-facet-value='Oval']/child::input[@type='checkbox']")
	 WebElement ovalChkbox;
	 
	 //Second filter
	 @FindBy(xpath="//*[@data-facet-value='Traditional']/child::input[@type='checkbox']")
	 WebElement traditionalChk;
	 
	  @FindBy(xpath= "//div[@id='pagination']/ul/li")
	  List<WebElement> totalButtons;

	  @FindBy(xpath="//ul[@id='category-product-drop']/li")
	  List<WebElement> lastPageItemsCount;
	  
	  // get the count from products count from the top of the page
	  @FindBy(xpath ="//span[@class='js-num-results']")
	  WebElement productsCount;
				 
	public String facetNarrowBysResult() throws Exception
	{
	WebDriverWait block = new WebDriverWait(driver,10);
	block.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='newsletter-modal']")));
	
	 Actions action = new Actions(driver);
	 action.sendKeys(Keys.ESCAPE);
	 action.build().perform();
	  // first filter check box
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ovalChkbox);
		Thread.sleep(5000);	
	 // 2nd filter check box
 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", traditionalChk);
		
		// get the total no of pages
		String totalNoPages=	driver.findElement(By.xpath("//div[@id='pagination']/ul/li["+totalButtons.size()+"]/a")).getAttribute("data-page");
		System.out.println("Total no of Pages:::" + totalNoPages);
		
		// click on the last page
		driver.findElement(By.xpath("//div[@id='pagination']/ul/li["+totalButtons.size()+"]/a")).click();
		System.out.println("last page count is" + lastPageItemsCount.size());
		
		int restOfThePagesCount = (Integer.parseInt(totalNoPages)-1)*48;
		System.out.println("Rest of the Pages items Count:: " + restOfThePagesCount);
		
		int toalCountFromThePages = restOfThePagesCount+lastPageItemsCount.size();
		System.out.println("Total items count from all the Pages:::" + toalCountFromThePages);
		
		String productCountfromTop = (productsCount.getText()).trim();
		System.out.println("Products count from Top of the Page :::" + productCountfromTop);
		
		return (productCountfromTop+"-"+toalCountFromThePages);
		
	
	}

}

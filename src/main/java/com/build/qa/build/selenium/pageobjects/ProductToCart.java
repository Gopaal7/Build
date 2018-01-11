package com.build.qa.build.selenium.pageobjects;

import javax.xml.xpath.XPath;

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

public class ProductToCart extends BaseFramework {
	
	
	public ProductToCart(WebDriver driver, Wait<WebDriver> wait ) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[contains(text(),' Archer 19-5/8')]")
	WebElement archer;
	
	@FindBy(xpath="//*[@id='configure-product-wrap']/button")
	WebElement addtoCartBtn;
	
	@FindBy(xpath="//*[@href='/index.cfm?page=cart:cart']")
	WebElement cart;
	
	@FindBy(xpath="//a[contains(text(),'Kohler K-2355  ')]")
	WebElement title;
	
	@FindBy(xpath="//button[@title='Email your cart']")
	WebElement emailYourCart;
	
	@FindBy(xpath=" //input[@id='yourName']")
	WebElement yourName;
	@FindBy(xpath=" //input[@id='yourEmail']")
	WebElement yourEmail;
	
	@FindBy(xpath=" //input[@id='recipientName']")
	WebElement recipientName;
	
	@FindBy(xpath=" //input[@id='recipientEmail']")
	WebElement recipientEmail;
	
	@FindBy(xpath=" //input[@id='recipientPhone']")
	WebElement recipientPhone;
	
	@FindBy(xpath=" //input[@id='otherRecipients']")
	WebElement otherRecipients;
	
	@FindBy(xpath=" //input[@id='projectTitle']")
	WebElement projectTitle;
	
	@FindBy(xpath="//textarea[@id=\"quoteMessage\"]")
	WebElement quoteMessage;
	
	@FindBy(xpath=" //input[@id='estimatedCloseDate']")
	WebElement estimatedCloseDate;
	
	@FindBy(xpath="//*[@id=\"cart-email\"]//button[@class=\"button-primary button js-email-cart-submit-button\"]")
	WebElement emailCartBtn;
	
	
	@FindBy(xpath="//*[@id=\"header\"]/div[4]/div/ul/li")
	WebElement emailConfirmMessage;
	
	@FindBy(xpath="//input[@id=\"search_txt\"]")
	WebElement searchTextBox;
	
	@FindBy(xpath="//*[@id=\"site-search\"]//button[1]")
	WebElement searchButton;
	
	@FindBy(xpath="//h1[@id=\"heading\"]")
	WebElement productTitle;
	
	public String searchProduct() throws InterruptedException
	{
		homePageLoad();
		searchTextBox.sendKeys("Quoizel MY1613ML");	
		searchButton.click();
		
		Thread.sleep(3000);
		return productTitle.getText();
		
		
	}
	public String AddProductToCart() throws InterruptedException
	{
		homePageLoad();
		
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", archer);
		 
		Thread.sleep(3000);
		 ((JavascriptExecutor) driver).executeScript( 
				 "arguments[0].click();",addtoCartBtn);
		Thread.sleep(4000);
			
			cart.click();
			System.out.println("Title :::" + title.getText());
			return title.getText();
	}
	
	public String emailCart() throws InterruptedException
	{
		AddProductToCart();
		emailYourCart.click();
		
		WebDriverWait block = new WebDriverWait(driver,10);
		block.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-email']")));

		yourName.sendKeys("Gopaal");
		yourEmail.sendKeys("Gopal.alet@gmail.com");
		recipientName.sendKeys("Gopi");
		recipientEmail.sendKeys("Gopal.alet@gmail.com");
		recipientPhone.sendKeys("706-761-4909");
		otherRecipients.sendKeys("jgilmore+SeleniumTest@build.com");
		
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", projectTitle);
			projectTitle.sendKeys("Kitchen");
			((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", quoteMessage);
			quoteMessage.sendKeys("This is Gopal Aleti, sending you a cart from my automation!");		

			emailCartBtn.click();
		Thread.sleep(2000);
		
		System.out.println("Email Confimration Message::: " + emailConfirmMessage.getText());
		
		return emailConfirmMessage.getText();
	}
	
	public void homePageLoad()
	{
		WebDriverWait block = new WebDriverWait(driver,10);
		block.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='newsletter-modal']")));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		action.build().perform();

	}
	
	}
	



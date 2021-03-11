package com.pg.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pg.test.base.BasePage;

public class LoginAndSignUp extends BasePage {
	
	public LoginAndSignUp() {
		PageFactory.initElements(driver, this);
	}
	
	//button[@class='signin-button btn-16']

	@FindBy(xpath = "//button[@class='signin-button btn-16']")
	private WebElement signInButton;

	@FindBy(xpath = "//span[contains(text(),'Email')]")
	private WebElement signInUsingEmail;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailAddressTextBox;


	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@class='md-raised md-primary md-button md-ink-ripple']")
	private WebElement signinbutton1;

	public void signInUsingEmail(String username, String password) throws InterruptedException {

		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", signInButton);

		signInUsingEmail.click();
		emailAddressTextBox.sendKeys(username);
		
		passwordTextBox.sendKeys(password);
		
		Thread.sleep(4000);
		signinbutton1.click();
		Thread.sleep(10000);
	}

}

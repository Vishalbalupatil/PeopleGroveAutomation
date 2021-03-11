package com.pg.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pg.test.base.BasePage;

public class HomePage extends BasePage{
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Opportunity')]")
	private WebElement opportunityTabLink;

	public void clickOnTheOpportunityTab() throws InterruptedException {
		opportunityTabLink.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}

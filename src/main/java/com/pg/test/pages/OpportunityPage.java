package com.pg.test.pages;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.pg.test.base.BasePage;

public class OpportunityPage extends BasePage{


	String Industrycheckbox = null;


	@FindBy(xpath = "//button[@id='jobSearchFilter']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchFilterTextfield;

	@FindBy(xpath = "//button[@class='ant-btn pg-filter-menu__btn pg-filter-menu__btn--apply']")
	private WebElement applybutton;



	@FindBy(xpath = "//button[@id='jobBookmarkFilter']")
	private WebElement bookMarkFilter;


	@FindBy(xpath = "//button[@id='jobExpertiseFilter']")
	private WebElement industryExpFilter;


	@FindBy(xpath = "//input[@placeholder='Search Industry by name']")
	private WebElement industryExpFilterTexfield;






	@FindBy(xpath = "//button[@id='jobLocationFilter']")
	private WebElement jobLocationFilter;

	@FindBy(xpath = "//input[@aria-label='Enter a city']")
	private WebElement jobLocationInput;


	@FindBy(xpath = "//span[contains(text(),'Virtual / Remote')]/preceding::span[1]")
	private WebElement jobLocationvitual_remote_checkbox;

	@FindBy(xpath = "//button[@id='jobTypeFilter']")
	private WebElement jobTypeFilter;




	@FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement jobTypeFiltertextField;

	@FindBy(xpath = "//button[@id='remainingFilter']")
	private WebElement moreFilterButton;


	@FindBy(xpath = "//span[contains(text(),'Clear All')]")
	private WebElement clearAllButton;



	@FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/label[1]")
	private WebElement SearchResult;

	@FindBy(how=How.XPATH,using="//div[@class='job-card__title title-overflow hidden-xs']")
	private List<WebElement> JobProfile;



	@FindBy(how=How.XPATH,using= "//div[@class='job-card__title title-overflow hidden-xs']/preceding::span[@class='job-card__subtitle hidden-xs']/span")
	private List<WebElement> CompanyNames;




	public OpportunityPage() {
		PageFactory.initElements(driver, this);
	}

	public int getTheSearchResult() {

		String text = SearchResult.getText();
		int res =0;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(text);
		while(m.find()) {
			res = Integer.parseInt(m.group());
		}
		return res;
	}


	public void getTheCompanyName() {
		int a = getTheSearchResult();

		for (WebElement ele:CompanyNames)
			System.out.println(ele.getText());
	}

	public void getCorrespondingJobProfile() {


		for (WebElement ele:JobProfile)
			System.out.println(ele.getText());
	}


	public void getCompanyNameAndJobProfile() {
 /*** This Method will print the company names and Job profiles ***/

		Iterator<WebElement> j1 = JobProfile.iterator();
		Iterator<WebElement> j2 = CompanyNames.iterator();
		while(j1.hasNext() && j2.hasNext()) 
		{

			System.out.println("Company Name : " +j1.next().getText());
			System.out.println("Profile : " +j2.next().getText());
		} 
	}

	public void searchfilter(String searchTxt) {
		searchButton.click();
		searchFilterTextfield.sendKeys(searchTxt);
		applybutton.click();
	}



	public void applySearchFilter(String searchString) throws InterruptedException {
		searchButton.click();
		Thread.sleep(2000);
		searchFilterTextfield.sendKeys(searchString);
		Thread.sleep(1000);
		applybutton.click();

	}


	public void applyFevoriteFilter(boolean flag) {
		if(flag==true) {
			bookMarkFilter.click();
		}
		else {
			
		}
	}

	public void selectIndustryFilter(String industryFiltername) {
		
		industryExpFilter.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'"+industryFiltername+"')]preceding-sibling::span/input")).click();
		applybutton.click();

	}

	public void selectlLocationFilter(String location,boolean virtual_remote ) {

		jobLocationFilter.click();
		if(virtual_remote==true) {
			jobLocationvitual_remote_checkbox.click();
		}
		jobLocationInput.sendKeys(location);
		applybutton.click();

	}



	


	public void selectJobFilter(String job) {
		
		jobTypeFilter.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+job+"')]//preceding-sibling::span/input")).click();
		applybutton.click();


	}

}

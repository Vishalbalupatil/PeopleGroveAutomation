package com.pg.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pg.test.base.BasePage;
import com.pg.test.pages.HomePage;
import com.pg.test.pages.LoginAndSignUp;
import com.pg.test.pages.OpportunityPage;


public class ListNumberOfJobs extends BasePage {

	HomePage homepage;
	LoginAndSignUp loginandsignin;
	OpportunityPage oppage;
	
	public ListNumberOfJobs() {
		super();
	}



	@BeforeMethod()
	public void setUp() throws InterruptedException, AWTException {
		initilization();

	} 
	@Test
	public void List_number_of_jobs_on_job_page_and_print() throws InterruptedException {
		loginandsignin = new LoginAndSignUp();
		loginandsignin.signInUsingEmail(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
		homepage.clickOnTheOpportunityTab();
		oppage = new OpportunityPage();
		int totaljobs =oppage.getTheSearchResult();
		Assert.assertEquals(totaljobs, 6);
		System.out.println("Total Jobs :" +totaljobs);
		oppage.getCompanyNameAndJobProfile();
		Assert.assertEquals(totaljobs, 6);
		
	}
	
	
	@AfterMethod
	public void quit() {
		driver.close();
	}
}

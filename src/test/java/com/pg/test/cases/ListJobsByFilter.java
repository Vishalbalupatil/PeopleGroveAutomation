package com.pg.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pg.test.base.BasePage;
import com.pg.test.pages.HomePage;
import com.pg.test.pages.LoginAndSignUp;
import com.pg.test.pages.OpportunityPage;

public class ListJobsByFilter 	extends BasePage{


		HomePage homepage;
		LoginAndSignUp loginandsignin;
		OpportunityPage oppage;
		
		public ListJobsByFilter() {
			super();
		}


		@BeforeMethod()
		public void setUp() throws InterruptedException, AWTException {
			initilization();

		} 
		@Test
		public void List_number_of_jobs_by_filter() throws InterruptedException {
			loginandsignin = new LoginAndSignUp();
			loginandsignin.signInUsingEmail(prop.getProperty("username"), prop.getProperty("password"));
			homepage = new HomePage();
			homepage.clickOnTheOpportunityTab();
			oppage = new OpportunityPage();
			oppage.applySearchFilter("people");
			oppage.applyFevoriteFilter(true);
			int jobs =oppage.getTheSearchResult();
			System.out.println("Total Jobs :" +jobs);
			oppage.getCompanyNameAndJobProfile();
			 
		}
		
		
		@AfterMethod
		public void quit() {
			driver.close();
		}
	}



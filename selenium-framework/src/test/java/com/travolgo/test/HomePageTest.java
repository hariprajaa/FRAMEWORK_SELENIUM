package com.travolgo.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travolgo.actiondriver.ActionDriver;
import com.travolgo.base.BaseClass;

public class HomePageTest extends BaseClass{
	private ActionDriver actiondriver;
	private LoginPagePOM loginPage;
	private HomePagePOM homepage;
	
	
	 //to click the login button 
    private By login_button = By.xpath("//p[normalize-space()='Login']");
    
	@BeforeMethod
	public void home_page_setup() {
		actiondriver = new ActionDriver(getDriver());
		loginPage = new LoginPagePOM(getDriver());
		homepage = new HomePagePOM(getDriver());
		
	}
	@Test
	public void testing_homepage_elements() {
		//login actions from login pom
		actiondriver.click(login_button);  
        loginPage.login("karthikeyan.r@codingmart.com","testpass");
		
		//homepage actions from homepage pom
		homepage.logo_display();
		homepage.amount_is_shown();
		homepage.logout_click();
		
	}
	
	
}

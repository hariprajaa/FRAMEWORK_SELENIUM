package com.travolgo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.travolgo.actiondriver.ActionDriver;
import com.travolgo.base.BaseClass;

//since we use By no need to use pagefactory
public class HomePagePOM extends BaseClass{
	
	private ActionDriver actiondriver;
	
	public void HomePagePOM(WebDriver actiondriver) {
		this.actiondriver = new ActionDriver(driver);
	}
	
	//locators
	
	private By logo = By.xpath("//img[contains(@src = 'travolgo-production.s3')]");
	
	private By amount_displayed = By.xpath("//p[@class = 'mb-0']/parent::div");
	
	private By logout = By.xpath("//img[@alt='logout']/parent::div");
	
	//action methods
	
	//method to check the display of logo
	public void logo_display() {
		actiondriver.isDisplayed(logo);
	}
	
	//method to check the display of amount
	public void amount_is_shown() {
		actiondriver.isDisplayed(amount_displayed);
	}
	
	//method to click logout 
	public void logout_click() {
		actiondriver.click(logout);
	}
	

	
	
}

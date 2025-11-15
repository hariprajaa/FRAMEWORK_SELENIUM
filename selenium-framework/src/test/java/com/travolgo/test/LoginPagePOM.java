package com.travolgo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.travolgo.actiondriver.ActionDriver;
import com.travolgo.base.BaseClass;

public class LoginPagePOM extends BaseClass{
	//constructor
	private ActionDriver actiondriver;
	public LoginPagePOM(WebDriver driver) {
	    this.actiondriver = new ActionDriver(driver);
	}


	//locators
	
	private By email = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name = 'password']");
	private By button = By.xpath("//button[@type='submit']");
	private By errorMessage = By.xpath("//div[@class='invalid-feedback']");
	
	//action methods 
	//1.method to perform login
	public void login(String email_value , String password_value) {
		actiondriver.enterText(email, email_value); //By and then value 
		actiondriver.enterText(password, password_value);
		actiondriver.click(button);
	}
	//Method to check if error message is diaplayed
	public boolean isErrorMessageDisplayed() {
		return actiondriver.isDisplayed(errorMessage);
	}
	
	//Method to get text from error message
	public String getErrorMessage() {
		return actiondriver.getText(errorMessage);
	}
	
	public void compareError(String expectedError) {
		
		 actiondriver.compareText(errorMessage, expectedError);
	}
}


package com.travolgo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travolgo.actiondriver.ActionDriver;
import com.travolgo.base.BaseClass;

public class LoginPageTest extends BaseClass {

    private ActionDriver actiondriver;
    private LoginPagePOM loginPage;
    
    //to click the login button 
    private By login_button = By.xpath("//p[normalize-space()='Login']");
    //instead of WebElement login_button = getDriver().findElement(By.xpath(""));
    									// [driver]

    @BeforeMethod
    public void loginpage_setup() {
        actiondriver = new ActionDriver(getDriver());  // ⭐ IMPORTANT 
        loginPage = new LoginPagePOM(getDriver());
    }

    @Test
    public void verifyLogin() {

        actiondriver.click(login_button);  

        loginPage.login("karthikeyan.r@codingmart.com","testpass");

      
    }
}

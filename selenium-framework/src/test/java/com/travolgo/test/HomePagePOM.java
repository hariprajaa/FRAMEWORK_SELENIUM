package com.travolgo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.travolgo.actiondriver.ActionDriver;

public class HomePagePOM {

    private ActionDriver actiondriver;

    //  Constructor
    public HomePagePOM(WebDriver driver) {
        this.actiondriver = new ActionDriver(driver);
    }

    //  Locators
    private By logo = By.xpath("//img[contains(@src, 'travolgo-production.s3')]");
    private By amount_displayed = By.xpath("//p[@class='mb-0']/parent::div");
    private By logout = By.xpath("//img[@alt='logout']/parent::div");

    //  Action Methods
    public boolean logo_display() {
        return actiondriver.isDisplayed(logo);
    }

    public boolean amount_is_shown() {
        return actiondriver.isDisplayed(amount_displayed);
    }

    public void logout_click() {
        actiondriver.click(logout);
    }
}

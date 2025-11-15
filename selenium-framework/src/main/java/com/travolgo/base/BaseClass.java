package com.travolgo.base;
//2
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected static Properties prop; //before suite will run only once so use protected static refer video time: 1:20:21
	protected static WebDriver driver;
	public static Logger logger;
	@BeforeSuite

	public void loadConfig() throws IOException {
		// Load the configuration file
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");

		prop.load(fis);

	}
	
	@BeforeMethod
	public void setup() throws IOException {
		System.out.println("Setting up WebDriver for:"+this.getClass().getSimpleName());
					
				launchBrowser();
				configureBrowser();
				staticWait(2); //pauses for 2 nano seconds before closing 

	}

	/*

	 * Initialize the WebDriver based on browser defined in config.properties file

	 */

	protected void launchBrowser() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.print("chrome browser triggered");
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Browser Not Supported:" + browser);
		}

	}

	/*

	 * Configure browser settings such as implicit wait, maximize the browser and

	 * navigate to the URL

	 */

	private void configureBrowser() {
		// Implicit Wait
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		// maximize the browser
		driver.manage().window().maximize();
		// Navigate to URL
		try {
			driver.get(prop.getProperty("url"));
			System.out.println("got url");
		} catch (Exception e) {
			System.out.println("Failed to Navigate to the URL:"+e.getMessage());
		}
	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("unable to quit the driver:"+e.getMessage());
			}

		}

	}
	//getter method
	public static WebDriver getDriver() { //to access webdriver for different classes
		return driver;
	}
	
	
	//setter method
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}

	//Static wait for pause

	public void staticWait(int seconds) {
		LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds)); //from before mthod 

	}

	public static Properties getProp() {
	    return prop;
	}


}
package com.qa.nil.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.nil.factory.DriverFactory;
import com.qa.nil.pages.HomePage;
import com.qa.nil.pages.LoginPage;
import com.qa.nil.pages.SignUpPage;


public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	SoftAssert softAssert; 
	HomePage homePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	

	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		homePage = new HomePage(driver);
		softAssert = new SoftAssert();
		loginPage = new LoginPage(driver);
		signUpPage = new SignUpPage(driver, homePage);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}

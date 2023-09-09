package com.qa.nil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.nil.utils.ElementUtil;
import com.qa.nil.utils.JavaScriptUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	private JavaScriptUtil jsutil;
	private HomePage homePage;
	
	private By email = By.id("login-form-email");
	private By password = By.id("login-form-password");
	private By loginBtn = By.id("login-form-sign-in-button");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
		jsutil = new JavaScriptUtil(driver);
		homePage = new HomePage(driver);
		
	}
	
	public void loginWithEmail() {
		homePage.loginBtnlink();
		eleutil.doSendKeys(email, "nehal30@yopmail.com");
		eleutil.doSendKeys(password, "Pass@123");
		eleutil.doClick(loginBtn);
	}

}

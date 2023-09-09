package com.qa.nil.pages;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.nil.utils.ElementUtil;
import com.qa.nil.utils.JavaScriptUtil;


public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	private JavaScriptUtil jsutil;
	
	//locators
	private By signupbtn = By.xpath("//button[text() = 'Sign up']");
	private By loginbtn = By.xpath("//button[text() = 'Log in']");
	private By joinClubBtn = By.xpath("//button[text()= 'Join the club']");
	private By joinClubCancelBtn = By.xpath("//button[text() = 'Cancel']");
	private By marketPlaceLink = By.xpath("//button[text() = 'Marketplace']");
	private By joinClubConfirmBtn = By.xpath("//button[text() = 'Confirm']");
	private By nxConnectLink = By.xpath("//button[text() = 'Connect']");
	private By registerNowBtn = By.xpath("//button[text() = 'Register Now']");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
		jsutil = new JavaScriptUtil(driver);
		
	}
	
	public SignUpPage signupBtnLink() {
		eleutil.waitForElementPresent(signupbtn, 30);
		eleutil.doClick(signupbtn);
		eleutil.waitForTitlePresent("Sign Up", 10);
		System.out.println(eleutil.pageTitle());
		return new SignUpPage(driver , this);
		
	}
	
	public void loginBtnlink() {
		eleutil.waitForElementPresent(loginbtn, 30);
		eleutil.doClick(loginbtn);
		eleutil.waitForTitlePresent("Log in", 10);
		//return eleutil.pageTitle();
	}
	
	public void joinClubBtn() {
		eleutil.waitForElementPresent(joinClubBtn, 30);
		eleutil.doClick(joinClubBtn);
		//jsutil.clickElementByJS(joinClubConfirmBtn);
		eleutil.waitForElementPresent(joinClubConfirmBtn, 30);
		eleutil.doClick(joinClubConfirmBtn);
		eleutil.waitForTitlePresent("Sign Up", 10);
		System.out.println(eleutil.pageTitle());
		
	}
	
	public void marketPlaceLink() {
		eleutil.waitForElementPresent(marketPlaceLink, 40);
		eleutil.doClick(marketPlaceLink);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parenetWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		String childwindowTitle = eleutil.pageTitle();
		System.out.println(childwindowTitle);
		driver.switchTo().window(parenetWindow);
		
	}
	
	public void nxConnectLink() {
		eleutil.waitForElementPresent(nxConnectLink, 40);
		eleutil.doClick(nxConnectLink);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parenetWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		String childwindowTitle = eleutil.pageTitle();
		System.out.println(childwindowTitle);
		driver.switchTo().window(parenetWindow);
	
	}
	
	
	public void joinAsAthelets() {
		eleutil.waitForElementPresent(registerNowBtn, 40);
		eleutil.doClick(registerNowBtn);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parenetWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		String childwindowTitle = eleutil.pageTitle();
		System.out.println(childwindowTitle);
		driver.switchTo().window(parenetWindow);
		
	}
	
	
	
	


}

	



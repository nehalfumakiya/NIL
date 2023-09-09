package com.qa.nil.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.nil.factory.DriverFactory;
import com.qa.nil.utils.ElementUtil;
import com.qa.nil.utils.JavaScriptUtil;

public class SignUpPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	private JavaScriptUtil jsutil;
	private HomePage homePage;
	
	
	private By emailBtn = By.id("sign-up-options-email");
	private By firstName = By.id("sign-up-form-username-firstName");
	private By lastName = By.id("sign-up-form-username-lastName");
	private By birthDatePlaceHolder = By.id("sign-up-form-username-birthDate");
	private By birthDateSelect = By.xpath("//button[@aria-label = 'Choose date']");
	private By birthYear = By.xpath("//div[@class = 'MuiYearPicker-root css-f09ynp']//div");
	private By birthMonth = By.xpath("//div[@class = 'MuiMonthPicker-root css-1616glu']//button");
	private By birthDate = By.xpath("//div[@class ='MuiDayPicker-monthContainer css-i6bazn']//div//button");
	private By email = By.id("sign-up-form-credentials-email");
	private By password = By.id("sign-up-form-credentials-password");
	private By confirmPW = By.id("sign-up-form-credentials-confirmPassword");
	private By nextbtn = By.id("sign-up-form-username-username-next-btn"); 
	private By nextbtn2 = By.id("sign-up-form-credentials-username-next-btn");
	private By nextbtn3 = By.id("sign-up-form-interests-username-next-btn");
	private By backbtn = By.id("sign-up-form-username-username-back-btn");
	private By backbtn2 = By.id("sign-up-form-credentials-username-back-btn");
	private By backbtn3 = By.id("sign-up-form-interests-username-back-btn");
	private By interest = By.id("sign-up-form-interests-preferencesIds'");
	private By termscheckbox = By.id("sign-up-form-interests-terms");
	private By createAccountBtn = By.id("sign-up-form-interests-next-btn");
	
	
	
	public SignUpPage(WebDriver driver, HomePage homePage) {
		this.driver = driver;
		this.homePage = homePage;
		eleutil = new ElementUtil(driver);
		jsutil = new JavaScriptUtil(driver);
		
	}
	
	
	public void signupWithEmail() {
		homePage.signupBtnLink();
		eleutil.doClick(emailBtn);
		eleutil.waitForElementsToBeVisible(firstName, 20);
		eleutil.doSendKeys(firstName, "Nehal");
		eleutil.doSendKeys(lastName, "Fumakiya");
		eleutil.doSendKeys(birthDatePlaceHolder, "01/12/2000");
//		eleutil.doClick(birthDateSelect);
//		List<WebElement> yearList = eleutil.getElements(birthYear);
//		
//		for(int i = 0 ; i < yearList.size() ; i++) {
//			String yearValue = yearList.get(i).getText();
//			if(yearValue.equalsIgnoreCase("2000")) {
//				yearList.get(i).click();
//			}
//		}
//		
//		eleutil.waitForElementPresent(birthMonth, 50);
//		
//		List<WebElement> monthList = eleutil.getElements(birthMonth);
//		
//		for(int i = 0 ; i < monthList.size() ; i++) {
//			String monthValue = monthList.get(i).getText();
//			if(monthValue.equalsIgnoreCase("May")) {
//				monthList.get(i).click();
//			}
//		}
//		
//		eleutil.waitForElementPresent(birthDate, 50);
//		List<WebElement> dayList = eleutil.getElements(birthDate);
//		
//		for(int i = 0 ; i < dayList.size() ; i++) {
//			String dayValue = dayList.get(i).getText();
//			if(dayValue.equalsIgnoreCase("10")) {
//				dayList.get(i).click();
//			}
//		}
		eleutil.waitForElementPresent(nextbtn, 30);
		eleutil.doClick(nextbtn);
		eleutil.waitForElementPresent(email, 50);
		eleutil.doSendKeys(email, "test1234@yopmail.com");
		eleutil.doSendKeys(password, "Pass@123");
		eleutil.doSendKeys(confirmPW, "Pass@123");
		eleutil.doClick(nextbtn2);
		eleutil.waitForElementPresent(interest, 50);
		//eleutil.selectDropDownValueWithoutSelect(interest, "Beauty Pageant");
		List<WebElement> interestList = eleutil.getElements(interest);
		
		for(int i = 0 ; i < interestList.size() ; i++) {
			String dayValue = interestList.get(i).getText();
			if(dayValue.equalsIgnoreCase("Beauty Pageant")) {
				interestList.get(i).click();
			}
			}
		eleutil.waitForElementPresent(nextbtn3, 50);
		eleutil.doClick(nextbtn3);
		eleutil.doClick(termscheckbox);
		eleutil.doClick(createAccountBtn);
		
	}

}

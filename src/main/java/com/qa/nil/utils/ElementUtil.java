package com.qa.nil.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.nil.factory.DriverFactory;


public class ElementUtil {

	
	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	

	
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	
	}

	/**
	 * This method is used to create the WebElement on the basis of By locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		
		WebElement element = null;
		//try {
			//waitForElementPresent(locator, 20);
			element = driver.findElement(locator);
			if(Boolean.parseBoolean(DriverFactory.highlight)) {
				jsUtil.flash(element);
			}
		//}catch(Exception e) {
			//System.out.println("Some exception occur while creating the Webelemet");
			//System.out.println(e.getMessage());
		//}
		
		return element;
	}
	
	/**
	 * This method is used to click on element	
	 * @param locator
	 */
	public void doClick(By locator) {
		//try {
			getElement(locator).click();	
		//}catch(Exception e) {
			//System.out.println("Some exception occur while clicking on the Webelemet");
			//System.out.println(e.getMessage());
		//}	
	}
	
	/**
	 * This method is used to passing value to the webelement
	 * @param locator
	 * @param value
	 */
	

	public void doSendKeys(By locator, String value) {
		//try {
			doClear(locator);
			getElement(locator).sendKeys(value);
		//}catch(Exception e) {
			//System.out.println("Some exception occur while passing value to the Webelemet");
			//System.out.println(e.getMessage());
		//}
		
	}
	
	
	public boolean isElementExist(By locator) {
		int elementCount = getElementCount(locator);
		System.out.println("Total Element found :" + elementCount );
		if(elementCount>=1) {
			System.out.println("Element is found :" + locator);
			return true;
		} else {
			System.out.println("Element is not found : " + locator);
			return false;
		}
		
		
	}
	
	public int getElementCount(By locator) {
		return getElements(locator).size();
	}
	
	
	
	public void waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		System.out.println("Not able to locate element" + locator);
	}
	
	
	public String waitForTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		
	}
	
	public void waitforElementToVisbile(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	/**
	 * This method us used to get all the values from drop down
	 * @param element
	 * @return 
	 */
		
		public ArrayList<String> getDropDownValues(WebElement element) {
			System.out.println("==============================");
			
			Select select = new Select(element);
			List<WebElement> dayList = select.getOptions();
			ArrayList<String> ar = new ArrayList<String>();
			
			for(int i =0; i<dayList.size(); i++) {
				String text = dayList.get(i).getText();
				//System.out.println(text);
				ar.add(text);
			
			}
			return ar;
		}
			
			
			/**
			 * This method is used to select the value from a drop down on the basis of given text
			 * @param locator
			 * @param value
			 */
			
			public void selectvalueFromDropDown(WebElement locator, String value) {
				Select select = new Select(locator);
				select.selectByVisibleText(value);
				
			}
			
			/**
			 * This method is used to select the value from a dropdown on the bais of
			 * given index
			 * 
			 * @param element
			 * @param index
			 */
		
			
			public void SelectValuefromDeopDowbBYIndex(WebElement element, int index) {
				Select select = new Select(element);
				select.selectByIndex(index);
				
			}
			
			
			
			
			
			public void selectDropDownValueWithoutSelect(By locator, String...value) {
				List<WebElement> daylist = getElements(locator);
				
				if(!value[0].equalsIgnoreCase("All")) {
				for(int i=0; i<daylist.size(); i++) {
					String text = daylist.get(i).getText();
					System.out.println(text);
					
					for(int k=0; k<value.length; k++) {
						if(text.equals(value[k])) {
							daylist.get(i).click();
							break;	
					}
					
					}
				}
			}
				
		//Select all the values:
				else {
					try {
					for(int all=0; all< daylist.size();all++) {
						daylist.get(all).click();
					}
					}
					catch(Exception e) {
						System.out.println("No such element are there");
					}
				}				
				
				
			}

			public String doGetText(By locator) {
				return getElement(locator).getText();
			}

			public String doGetAttribute(By locator, String attrName) {
				return getElement(locator).getAttribute(attrName);
			}

			public boolean doIsDisplayed(By locator) {
				return getElement(locator).isDisplayed();
			}
			
			public void doClear(By locator) {
				getElement(locator).clear();
			}
			
			public List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			}

			public boolean doIsEnabled(By locator) {
				return getElement(locator).isEnabled();
			}
			
			public List<WebElement> getElements(By locator) {
				List<WebElement> elementsList = driver.findElements(locator);
				return elementsList;
			}
			
			public void clickOnElement(By locator, String value) {
				List<WebElement> eleList = getElements(locator);
				System.out.println(eleList.size());
				for (WebElement e : eleList) {
					if (e.getText().equals(value)) {
						e.click();
						break;
					}
				}
			}
			
		public void multipleWindowHandles(By locator) {
			List<WebElement> linksUrl = getElements(locator);
			for(WebElement e: linksUrl) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(e)).click();
				Set<String> urlHandles = driver.getWindowHandles();
				String parentWindow = driver.getWindowHandle();
				Iterator<String> it = urlHandles.iterator();
				while(it.hasNext()) {
				String child1 = it.next();
				if (!parentWindow.equalsIgnoreCase(child1)) {
				driver.switchTo().window(child1);
				System.out.println(driver.getTitle());
				driver.close();
			}
			}	
			driver.switchTo().window(parentWindow);
			}
			

		}
		
		public String pageTitle() {
			return driver.getTitle();
		}
	

	
}

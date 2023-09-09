package com.qa.nil.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionsManager optionsManager;
	
public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the webDriver 
	 * @param browserName
	 * @return this will return the driver
	 */
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is :" +browserName );
		highlight = prop.getProperty("highlight");
		
		optionsManager = new OptionsManager(prop);
	
	if(browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver(optionsManager.getChromeOptions());
		tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
	}
	
	WebDriver driver = new ChromeDriver();
	
	else if(browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
	}
	
	else if(browserName.equals("safari")) {
		WebDriverManager.safaridriver().setup();
		//driver = new SafariDriver();
		tlDriver.set(new SafariDriver());
	}
	else {
		System.out.println("Please pass the right browser" + browserName);
	}
	
	getDriver().manage().window().maximize();
	getDriver().manage().deleteAllCookies();
	getDriver().get(prop.getProperty("url"));
	
	return getDriver();
	
	}
	
	
	/**
	 * getdriver(): it will return a thread local copy of the webdriver
	 * @return 
	 */
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	/**
	 * THis method is used to initialize the properties
	 * @return this will return properties prop reference
	 */
	
	public Properties init_prop() {
		
		prop = new Properties();
		FileInputStream ip = null;
		
		String env = System.getProperty("env"); //qa/stag/uat
		
		if(env == null) {
			System.out.println("Running on prod env: ");
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			else {
				System.out.println("Running on environment" + env);
				try {
				switch (env) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stag.config.properties");
					break;		
				default:
					System.out.println("Please pass right environment....");
					break;
				}
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return prop;
				
		}
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
		
}
	
	
	
	



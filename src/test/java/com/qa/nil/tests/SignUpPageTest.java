package com.qa.nil.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.nil.pages.HomePage;
import com.qa.nil.pages.SignUpPage;

public class SignUpPageTest extends BaseTest{
	
	
	HomePage homePage;

	
	
	@Test
	public void signUpTest() {
		signUpPage.signupWithEmail();
		
	}

}

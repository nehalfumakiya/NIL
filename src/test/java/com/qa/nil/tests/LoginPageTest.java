package com.qa.nil.tests;

import org.testng.annotations.Test;



public class LoginPageTest extends BaseTest {
	
	@Test
	public void loginWithEmailTest() {
		loginPage.loginWithEmail();
	}

}

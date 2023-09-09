package com.qa.nil.tests;

import org.testng.annotations.Test;



public class HomePageTestPage extends BaseTest {
	
	@Test
	public void signupbtnTest() {
		homePage.signupBtnLink();
	}
	
	@Test
	public void joinClubCancelbtnTest() {
		homePage.joinClubBtn();
	}
	
	@Test
	public void loginbtnTest() {
		homePage.loginBtnlink();
	}
	
	@Test
	public void marketPlacelinkTest() {
		homePage.marketPlaceLink();
		
	}
	
	@Test
	public void nxConnectLinkTest() {
		homePage.nxConnectLink();
	}
	
	@Test
	public void joinAsAtheletRegisterNowBtnTest() {
		homePage.joinAsAthelets();
	}
	
	
	
	
	
	
}

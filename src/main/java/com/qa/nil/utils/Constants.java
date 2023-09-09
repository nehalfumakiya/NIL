package com.qa.nil.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants{
	
	public static final int DEFAULT_TIME_OUT = 10;
	public static final int IMAC_IMAGE_COUNT = 4  ;
	public static final String MAIN_PAGE_TITLE = "Follow me on";
	public static final String USER_SHORT_NAME = "@keith.miller";
	public static final String USER_PROFILE_NAME = "keith" + '\n' +"miller";
	public static final String TC_PAGE_TITLE = "Terms and Conditions";
	public static final String PRIVACY_PAGE_TITLE = "Privacy Notice";
	public static final String FOOTER_TITLE = "Copyright 2022 nXconnect, Inc." + 
												'\n' + "Terms And Conditions" + 
												'\n'+ ","+
												'\n'+ "Privacy Policy"+
												'\n'+ "v0.0.23";
	public static final String GOOGLE_STORE_TITLE = "nXlvl: Personal Brand Builder - Apps on Google Play";
	public static final String APPLE_STORE_TITLE = "nXlvl: Personal Brand Builder on the App Store";
;	
	public static List<String> getQRCodeList() {
		List<String> qrDesc = new ArrayList<String>();
		qrDesc.add("CREATE YOUR OWN FREE NXCONNECT.ME PAGE");
		qrDesc.add("Download the app");
		return qrDesc;
	}
	
	public static List<String> titleList() {
		List<String> pageTitles = new ArrayList<String>();
		pageTitles.add("Follow me on");
		pageTitles.add("Support");
		pageTitles.add("Videos");
		pageTitles.add("Connect");
		pageTitles.add("Websites");
		pageTitles.add("News");
		pageTitles.add("Music");
		pageTitles.add("Endorsements");
		pageTitles.add("Stores");
		pageTitles.add("Products");
		pageTitles.add("Links");
		
		return pageTitles;
	}

}

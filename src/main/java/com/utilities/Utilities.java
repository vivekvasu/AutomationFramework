package com.utilities;

import org.openqa.selenium.WebDriver;

public class Utilities {

	/**
	 * This method is to delete all browser cookies
	 * 
	 * @param driver - WebDriver object
	 * @return - True if all the cookies are deleted, else false
	 */
	public static boolean deleteCookies(WebDriver driver) {
		boolean isSuccess = false;
		try {
			driver.manage().deleteAllCookies();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to delete cookies");
			Report.info("Exception : " + e.getMessage());
		}
		return isSuccess;
	}
	
	/**
	 * This method is to close the open browser and quit
	 * 
	 * @param driver - WebDriver object
	 * @return - True if the browser is closed, else false
	 */
	public static boolean closeAndQuitBrowser(WebDriver driver) {
		boolean isSuccess = false;
		try {
			driver.close();
			driver.quit();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to close and quit browser");
			Report.info("Exception : " + e.getMessage());
		}
		return isSuccess;
	}
}

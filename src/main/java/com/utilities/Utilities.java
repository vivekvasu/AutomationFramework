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
		Report.info("Entering method::deleteCookies()");
		boolean isSuccess = false;
		try {
			driver.manage().deleteAllCookies();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to delete cookies");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::deleteCookies() with '" + isSuccess + '"');
		return isSuccess;
	}
	
	/**
	 * This method is to close the open browser
	 * 
	 * @param driver - WebDriver object
	 * @return - True if the browser is closed, else false
	 */
	public static boolean closeBrowser(WebDriver driver) {
		Report.info("Entering method::closeBrowser()");
		boolean isSuccess = false;
		try {
			driver.close();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to close the browser");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::closeBrowser() with '" + isSuccess + '"');
		return isSuccess;
	}
	
	/**
	 * This method is to quit the WebDriver
	 * 
	 * @param driver - WebDriver object
	 * @return - True if the browser is closed, else false
	 */
	public static boolean quitDriver(WebDriver driver) {
		Report.info("Entering method::quitDriver()");
		boolean isSuccess = false;
		try {
			driver.close();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to quit browser");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::quitDriver() with '" + isSuccess + '"');
		return isSuccess;
	}
	
	/**
	 * This method is maximize the browser window
	 * 
	 * @param driver - WebDriver object
	 * @return - True if the browser is maximized, else false
	 */
	public static boolean maximizeWindow(WebDriver driver) {
		Report.info("Entering method::maximizeWindow()");
		boolean isSuccess = false;
		try {
			driver.manage().window().maximize();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to maximize the window");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::maximizeWindow() with '" + isSuccess + '"');
		return isSuccess;
	}
}

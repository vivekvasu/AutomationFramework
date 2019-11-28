package com.framework.tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.DriverManager;
import com.utilities.ExtentManager;
import com.utilities.PropertyUtils;
import com.utilities.Report;
import com.utilities.Utilities;
import com.utilities.VideoRecorder;

public class FunctionalTests {

	private ExtentReports extent;
	private VideoRecorder recorder;
	public static Properties InputProperties;
	public WebDriver driver;
	public static ThreadLocal<ExtentTest> methods = new ThreadLocal<ExtentTest>();
	boolean recordVideo = false;
	String runFrom = "";
	String runUntil = "";
	boolean skipExecution = true;

	@BeforeSuite
	public void doInitialSetUp(ITestContext context) {
		PropertyConfigurator.configure("./Resources/log4j.properties");
		// Turn off the freemarker logger
		System.setProperty("org.freemarker.loggerLibrary", "none");
		InputProperties = PropertyUtils.readPropertyFile("./Resources/global.properties");
		extent = ExtentManager.getInstance();
		recordVideo = InputProperties.getProperty("recordVideo").equalsIgnoreCase("true") ? true : false;
		if (recordVideo) {
			recorder = VideoRecorder.startRecording(context.getCurrentXmlTest().getName());
		}
		runFrom = InputProperties.getProperty("runFrom").toLowerCase();
		runUntil = InputProperties.getProperty("runUntil").toLowerCase();
	}

	@BeforeTest
	public void beforeTest(XmlTest method) {
		Report.info("-------" + method.getName() + "-------");
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		Report.info("-------" + method.getName() + "-------");
		driver = DriverManager.getWebDriver(InputProperties.getProperty("browser"));
		Utilities.maximizeWindow(driver);
		ExtentTest tests = extent.createTest(method.getName());
		methods.set(tests);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			methods.get().pass("Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			methods.get().fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			methods.get().skip(result.getThrowable());
		}
		Utilities.deleteCookies(driver);
		Utilities.closeBrowser(driver);

		if(driver != null)
		{
			Utilities.quitDriver(driver);
		}

	}

	@AfterSuite
	public void quitBrowser() {
		extent.flush();
		VideoRecorder.stopRecording(recorder);
	}

}

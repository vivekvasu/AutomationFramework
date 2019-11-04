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
import com.utilities.DriverFactory;
import com.utilities.ExtentManager;
import com.utilities.PropertyUtils;
import com.utilities.VideoRecorder;

public class FunctionalTests {
	
	WebDriver driver;
	private ExtentReports extent;
	private VideoRecorder recorder;
	public static Properties InputProperties;
	public static ThreadLocal<ExtentTest> methods = new ThreadLocal<ExtentTest>();
	public static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public synchronized void doInitialSetUp(ITestContext context)
	{
		PropertyConfigurator.configure("log4j.properties");
		//Turn off the freemarker logger
		System.setProperty("org.freemarker.loggerLibrary", "none");
		InputProperties = PropertyUtils.readPropertyFile("./global.properties");
		driver = DriverFactory.getWebDriver();
		extent = ExtentManager.getInstance();
		try {
			recorder =	VideoRecorder.startRecording(context.getCurrentXmlTest().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public synchronized void beforeTest(XmlTest method) 
	{
		ExtentTest tests = extent.createTest(method.getName());
		parentTest.set(tests);
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) 
	{
		ExtentTest testmethod = parentTest.get().createNode(method.getName());
		methods.set(testmethod);
	}

	@AfterMethod
	public void afterMethod (ITestResult result)
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			methods.get().pass("Test Passed");
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			methods.get().fail(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			methods.get().skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void quitBrowser ()
	{
		extent.flush();
		VideoRecorder.stopRecording(recorder);
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
}

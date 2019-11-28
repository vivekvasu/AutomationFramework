package com.framework.tests;

import org.testng.annotations.Test;

import com.utilities.Report;

public class SampleTests extends FunctionalTests {

	@Test
	public void firstTest() {
		Report.info("Inside firstTest");
		driver.get("http://www.google.com/");
		Report.info("URL : " + driver.getCurrentUrl());
		Report.info("Title : " + driver.getTitle());
	}
	
	@Test
	public void secondTest() {
		Report.info("Inside secondTest");
		driver.get("http://www.filpkart.com/");
		Report.info("URL : " + driver.getCurrentUrl());
		Report.info("Title : " + driver.getTitle());
	}
	
	@Test
	public void thirdTest() {
		Report.info("Inside thirdTest");
		driver.get("http://www.amazon.com/");
		Report.info("URL : " + driver.getCurrentUrl());
		Report.info("Title : " + driver.getTitle());
	}
	
	@Test
	public void fourthTest() {
		Report.info("Inside fourthTest");
	}
}

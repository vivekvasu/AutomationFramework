package com.framework.tests;

import org.testng.annotations.Test;

import com.utilities.Report;

public class SampleTests extends FunctionalTests {

	@Test
	public void firstTest() {
		Report.info("Inside firstTest");
	}
	
	@Test
	public void secondTest() {
		Report.info("Inside secondTest");
	}
	
	@Test
	public void thirdTest() {
		Report.info("Inside thirdTest");
	}
	
	@Test
	public void fourthTest() {
		Report.info("Inside fourthTest");
	}
}

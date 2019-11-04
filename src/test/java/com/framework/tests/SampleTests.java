package com.framework.tests;

import org.testng.annotations.Test;

public class SampleTests extends FunctionalTests {

	@Test
	public void firstTest()
	{
		driver.get("https://www.google.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().to("https://www.facebook.com/");
	}
}

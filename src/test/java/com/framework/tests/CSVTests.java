package com.framework.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.utilities.CSVUtils;

/**
 * @author Vivek Vasu
 */
public class CSVTests extends FunctionalTests {

	@Test
	public void GetCSVColumnValuesTest() throws InterruptedException
	{
		String filePath = "./Resources/file.csv";
		List<String> csvList = CSVUtils.GetCSVColumnValues(filePath, "value", new String[] {"Name", "Value"});
		for(String text : csvList)
		{
			System.out.println(text);
		}
	}
}

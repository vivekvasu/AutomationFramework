package com.framework.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.utilities.CSVUtils;
import com.utilities.Report;

/**
 * @author Vivek Vasu
 */
public class CSVTests extends FunctionalTests {

	@Test
	public void getCSVColumnValuesTest()
	{
		String filePath = "./Resources/file.csv";
		List<String> csvList = CSVUtils.getCSVColumnValues(filePath, "value", new String[] {"Name", "Value"});
		for(String text : csvList)
		{
			Report.info(text);
		}
	}
}

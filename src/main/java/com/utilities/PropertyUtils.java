package com.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

	/**
	 * This method is to read the properties file
	 * 
	 * @param filePath - Path of the property file
	 * @return - The property file
	 */
	public static Properties readPropertyFile(String filePath)
	{
		HTMLLogger.info("Entered method::readPropertyFile with '" + filePath + "'");
		InputStream input = null;
		Properties properties = null;
		try {
			input = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(input);
		}
		catch (Exception e) {
			HTMLLogger.info("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return properties;
	}
}

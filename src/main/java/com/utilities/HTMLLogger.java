package com.utilities;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;

public class HTMLLogger extends HTMLLayout {

	public static Logger logger = Logger.getLogger(HTMLLogger.class);
	
	public static void info(String message)
	{
		logger.info(message);
	}
}

package com.utilities;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;

public class Report extends HTMLLayout {

	private static Logger logger = Logger.getLogger(Report.class);
	
	public static void info(String message)
	{
		logger.info("Thread " + Thread.currentThread().getId() + " - " + message);
	}
}

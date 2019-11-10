package com.utilities;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * This class contains all the functions to handle CSV file
 * 
 * @author Vivek Vasu
 */
public class CSVUtils {

	/**
	 * This method is to get all the CSV values column wise
	 * 
	 * @param filePath
	 * @param columnName
	 * @param headers
	 * @return - This method returns the list of CSV values of the give header column 
	 */
	public static List<String> getCSVColumnValues(String filePath, String columnName, String[] headers)
	{
		Report.info("Executing GetCSVColumnValues");
		Reader reader = null;
		CSVParser csvParser = null;
		String csvValue = null;
		List<String> csvColumnList = null;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
			csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(headers).withIgnoreHeaderCase().withTrim());
			csvColumnList = new ArrayList<>();
			for (CSVRecord csvRecord : csvParser) 
			{
				csvValue = csvRecord.get(columnName);
				csvColumnList.add(csvValue);
			}
			csvParser.close();
		} catch (IOException e) 
		{
			Report.info(e.getMessage());
		}
		Report.info("Exiting GetCSVColumnValues");
		return csvColumnList;
	}

	/**
	 * This method is to get all the CSV values column wise
	 * 
	 * @param filePath
	 * @param index
	 * @return - This method returns the list of CSV values of the give header column 
	 */
	public static List<String> getCSVColumnValues(String filePath, Integer index)
	{
		Reader reader = null;
		CSVParser csvParser = null;
		String csvValue = null;
		List<String> csvColumnList = null;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));
			csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			csvColumnList = new ArrayList<String>();
			for (CSVRecord csvRecord : csvParser) 
			{
				csvValue = csvRecord.get(index);
				csvColumnList.add(csvValue);
			}
			csvParser.close();
		} catch (IOException e) 
		{
			Report.info(e.getMessage());
		}
		return csvColumnList;
	}
}

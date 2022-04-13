package com.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropFile_Util {
  
	/**
	 * @author sivaram
	 * This method read data from property file
	 * @param key
	 * @return value based on key you are passing
	 * @throws IOException
	 */
	public String readdatafrompropfile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IAutoConstants.popfilepath);
		Properties prop = new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
	
	/**
	 * @author sivaram
	 * This method helps us to read data
	 * @param path
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readdatafrompropfile(String path,String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
}

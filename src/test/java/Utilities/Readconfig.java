package Utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig {
	
	Properties properties;
	
	String path="config.properties";

	//constructor
	
	public Readconfig()
	{
		
		properties=new Properties(); 
	try {
		FileInputStream fis;
		fis = new FileInputStream(path);
		properties.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
	
		if(value!=null)
		
			return value;
		
	    else
				throw new RuntimeException("url not specified in config file.");
				
	
	
	}
}

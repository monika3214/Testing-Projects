package com.salesforce.autimationscript.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.salesforce.automationscript.AutomationScript;

public class  CommonUtilities  {
	
	public static String readPropertyData(String key)throws IOException{
	
		String filepath = Constants.APPLICATION_PROPERTIES_PATH;
	
		FileInputStream fs = null;
	
		fs = new FileInputStream(filepath);
	
		Properties ob = new Properties();
		ob.load(fs);
		String value = ob.getProperty(key);
		// System.out.println("value is" + value);
		return value;
	
	}

}

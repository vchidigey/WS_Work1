package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Date: July 25th 2018
 * @author Vijayachandar Chidigey
 *
 */
public class User {

	/** Variables */
	public HashMap<String, String> suiteProperties = new HashMap<String, String>();
	public HashMap<String, String> variables = new HashMap<String, String>();
	public HashMap<String, String> resultMap = new HashMap<String, String>();
	public static HashMap<String, String> emailMap = new HashMap<String, String>();
	public List<String> ignoreTags = new ArrayList<String>();
	
	/**
	 * Method to set variables in map
	 * @param ra
	 */
	public void getVariables(ReusableActions ra) {
		String date = ra.getDate("MM/dd/YYYY");
		String eDigits = ra.getDate("ddYYmmss");
		String tDigits = ra.getDate("MMddYYmmss");
		String timeStamp = ra.getDate("MM/dd/YYYY HH:mm:ss");
		
		variables.put("_currentDate_", date);
		variables.put("_eightDigits_", eDigits);
		variables.put("_tenDigits_", tDigits);
		variables.put("_timeStamp_", timeStamp);
	}
	
	/**
	 * Method to get property values from property file
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getDataFromPropertiesFile(String key) throws Exception {
		String returnValue = null;
		try {
			Properties prop = new Properties();
			String path = new File(User.class.getProtectionDomain().getCodeSource().getLocation().toURI()).toString();
			path = path.replaceAll("\\\\", "/");
			path = path.substring(0, path.indexOf("\bin"));
			FileInputStream propFile = new FileInputStream(path+"/src/properties/Properties.properties");
			prop.load(propFile);
			returnValue = prop.getProperty(key);
			propFile.close();
		}catch(Exception e) {
			throw new Exception("Failed to get properties from property file!\nError description: "+e.toString());
		}
		return returnValue;
	}
}

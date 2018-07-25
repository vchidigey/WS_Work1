package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

/**
 * Date: July 25th 2018
 * @author Vijayachandar Chidigey
 *
 */
public class ReusableActions {

	/**
	 * Method to get date in required format
	 * @param requiredDateFormat
	 * @return
	 */
	public String getDate(String requiredDateFormat) {
		String returnValue = null;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(requiredDateFormat);
		returnValue = df.format(date);
		return returnValue;
	}
	
	/**
	 * Method to get future date in required date format by passing number of days as parameter
	 * @param requiredDateFormat
	 * @param days
	 * @return
	 */
	public String getFutureDate(String requiredDateFormat, int days) {
		String returnValue = null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date date = c.getTime();
		DateFormat df = new SimpleDateFormat(requiredDateFormat);
		returnValue = df.format(date);
		return returnValue;
	}
	
	/**
	 * Method to encrypt String
	 * @param en
	 * @return
	 */
	public String encryptString(String en) {
		String encryptedString = Base64.getEncoder().encodeToString(en.getBytes());
		return encryptedString;
	}
	
	public String decryptString(String en) {
		byte[] decryptedString = Base64.getDecoder().decode(en);
		en = new String(decryptedString);
		return en;
	}
}

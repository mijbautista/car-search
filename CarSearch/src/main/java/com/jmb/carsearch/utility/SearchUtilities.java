package com.jmb.carsearch.utility;

public class SearchUtilities {
	
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}

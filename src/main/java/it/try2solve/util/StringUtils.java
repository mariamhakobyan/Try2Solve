package it.try2solve.util;

public class StringUtils {

	public static String arrayToDelimitedString(Object[] arr, String delim) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(delim);
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}
	
	public static boolean isBlank(String obj) {
		if(obj == null || obj.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotBlank(String obj) {
		return !isBlank(obj);
	}

}

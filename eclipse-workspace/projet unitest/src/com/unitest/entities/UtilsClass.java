package com.unitest.entities;

public class UtilsClass {
	
	final static String NUMBER_PATTERN = "^((?:\\+33\\s|0)[1-9](?:\\s\\d{2}){4})$";
	
	/**
	 * Return true if phone number is valide
	 * false if empty or not valide
	 * 
	 * @param phoneNumber
	 * @return true if phone number is valide, false otherwise.
	 */
	public static boolean isvalidNumber(String phoneNumber) {

		if (phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.matches(NUMBER_PATTERN)) {
			return false;
		}

		return true;

	}
	
	public static boolean isPair(int n) {
		return (n%2==0);
	}
	
	
	public static boolean isValidMail(String mail) {
		return false;
		// TODO document why this method is empty
 }
	
	public static boolean isValidLastName(String lastName) {
		return false;
		// TODO document why this method is empty
	}
	
	public static boolean isValidFirstName(String firstName) {
		return false;
		// TODO document why this method is empty
	}
	
	
}

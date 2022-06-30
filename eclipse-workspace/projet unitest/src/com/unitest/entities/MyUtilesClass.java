package com.unitest.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtilesClass {

    /**
     *  
     */

	final static String NUMBER_PATTERN = "^((?:\\+33\\s|0)[1-9](?:\\s\\d{2}){4})$";
    // méthode 
	
	/**
	 * Return true if phone number is valide
	 * false if empty or not valide
	 * @param phoneNumber
	 * @return 
	 */
	public static boolean isvalidNumber(String phoneNumber) {

		if (phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.matches(NUMBER_PATTERN))
			return false;

		return true;

	}
	
	
	public static int  isPair(int nb)  {
		return nb % 2;
	}

	public static void main(String[] args) {

		boolean b = isvalidNumber("06 23 44 94 97");
		System.out.println(b);
	}

}

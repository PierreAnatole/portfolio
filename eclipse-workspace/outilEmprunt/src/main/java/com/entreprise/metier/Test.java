package com.entreprise.metier;

public class Test {
	public static void main(String[] args) {
			String input = "30.56";
			String regex="0*(([0-9])|([1-4][0-9])|50)";
			String r2ff ="(0*(([0-9])|([1-4][0-9])))\\.([0-9]{1,2})";
			System.out.println(input.matches(r2ff));
		
	}
}

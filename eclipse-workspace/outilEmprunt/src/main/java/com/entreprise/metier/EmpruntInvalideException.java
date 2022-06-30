package com.entreprise.metier;

public class EmpruntInvalideException extends Exception{
	public String getMessage() {
		return "Duree invalide";
	}
}

package exception;

import entities.Magasin;

public class MagasinPleinProduitException extends Exception{
	
	public MagasinPleinProduitException() {
		
	}
	
	public MagasinPleinProduitException(String s) {
		super(s);
	}
	
	@Override
	public String getMessage() {
		return "Magasin plein ! capacité maximale de "+Magasin.PRODUITS_MAX+" produits atteint.";
	}
}

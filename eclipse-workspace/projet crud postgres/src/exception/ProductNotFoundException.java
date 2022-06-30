package exception;

import entities.Magasin;

public class ProductNotFoundException extends Exception{
	
	public String getMessage() {
		return "Produit non trouvé.";
	}
}

package exception;

import entities.Magasin;

public class MagasinPleinEmployeException extends Exception{
	
	public MagasinPleinEmployeException() {
		super();
	}

	public MagasinPleinEmployeException(String s) {
		super(s);
	}
	
	@Override
	public String getMessage() {
		return "Magasin plein ! capacité maximale de "+Magasin.EMPLOYES_MAX+" employes atteint.";
	}
}

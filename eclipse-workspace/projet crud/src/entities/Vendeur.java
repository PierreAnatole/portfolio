package entities;

public class Vendeur extends Employe{
	private double tauxDeVente;
	public static final int REMUNERATION_VENDEUR=800;
	
	
	@Override
	public double calculeSalaire() {
		return REMUNERATION_VENDEUR*(this.tauxDeVente/100);
	}
	
	

}

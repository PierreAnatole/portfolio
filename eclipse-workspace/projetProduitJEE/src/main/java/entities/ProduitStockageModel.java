package entities;

import java.util.ArrayList;

public class ProduitStockageModel {
	private ArrayList<Produit> produits = new ArrayList<Produit>();
	
	public ArrayList<Produit> getProduits() {
		return produits;
	}
	
	public void  setProduits(ArrayList<Produit> produits) {
		this.produits=produits;
	}
}

package entities;

import java.io.Serializable;

public class Produit implements Serializable{

	private int id;
	private String designation;
	private int prix;
	private int quantite;
	
	// Constructeurs
	
	public Produit(String designation, int prix, int quantite) {
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	
	public Produit(int id, String designation, int prix, int quantite) {
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}

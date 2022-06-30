package fr.chamonix.entities;

import java.io.Serializable;

public class Produits implements Serializable {
	// attributs de la classe prduit 
	private Long id;
	private String designation;
	private double prix;
    private int quantite;
	/**
	 * 
	 */
	public Produits() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param designation
	 * @param prix
	 * @param quantite
	 */
	public Produits(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Long getId() {
		return id;
	}
	public String getDesignation() {
		return designation;
	}
	public double getPrix() {
		return prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Produits [id=" + id + ", designation=" + designation + ", prix=" + prix + ", quantite=" + quantite
				+ "]";
	}
	
	
	
}


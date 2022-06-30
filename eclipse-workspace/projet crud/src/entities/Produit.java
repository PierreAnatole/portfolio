package entities;

import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Objects;

public class Produit {
	private int id;
	private String libelle;
	private BigDecimal prix;
	private String saison;
	private boolean estFrais;
	
	// Constructeurs
	public Produit() {
		
	}
	

	public Produit(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	/**
	 * Constructeur demandant toutes les informations pour créer un produit.
	 * 
	 * @param id L'id du produit.
	 * @param libelle Le nom du produit.
	 * @param prix Le prix du produit.
	 * @param saison La saison de récolte du produit.
	 * @param estFrais Etat de fraicheur du produit.
	 */
	public Produit(int id, String libelle, BigDecimal prix, String saison,boolean estFrais){
		this.id = id;
		this.libelle = libelle;
		this.prix=prix;
		this.saison=saison;
		this.estFrais=estFrais;
	}
	
	

	/**
	 * Constructeur demandant toutes les informations pour créer un produit et gérant la conversion du prix de type double en BigDecimal.
	 * 
	 * @param id L'id du produit.
	 * @param libelle Le nom du produit.
	 * @param prix Le prix du produit.
	 * @param saison La saison de récolte du produit.
	 * @param estFrais Etat de fraicheur du produit.
	 */
	public Produit(int id, String libelle, double prix, String saison,boolean estFrais) {
		this.id = id;
		this.libelle = libelle;
		this.prix=new BigDecimal(prix);
		this.saison=saison;
		this.estFrais=estFrais;
	}


	// Methodes
	public static boolean comparer(Produit p1, Produit p2) {
		boolean sameId = p1.getId()==p2.getId();
		boolean sameLibelle = p1.getLibelle().equals(p2.getLibelle());
		boolean samePrix = p1.getPrix()==p2.getPrix();
		return(sameId && sameLibelle && samePrix);
	}
	
	public boolean comparer(Produit toCompare) {
		boolean sameId = this.id==toCompare.getId();
		boolean sameLibelle = this.libelle.equals(toCompare.getLibelle());
		boolean samePrix = this.prix==toCompare.getPrix();
		return(sameId && sameLibelle && samePrix);
	}
	
	@Override
	public String toString() {
		String res ="";
		
		String cleanId = ((this.id)==0) ? "" : Integer.toString(this.id);
		String cleanLibelle = (Objects.isNull(this.libelle)) ? "" : this.libelle;
		String cleanPrix = (Objects.isNull(this.prix)) ? "" : this.prix.toString();
		String cleanSaison = (Objects.isNull(this.saison)) ? "" : this.saison;
		String cleanEstFrais = (Objects.isNull(this.estFrais)) ? "" : String.valueOf(this.estFrais);
		
		res = String.format("%15s %15s %15s %15s %15s\n", cleanId, cleanLibelle, cleanPrix, cleanSaison, cleanEstFrais);
		return res;
	}
	
	



	// Getters & setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
			this.prix = prix;
	}
	public String getSaison() {
		return saison;
	}
	public void setSaison(String saison) {
		this.saison = saison;
	}
	public boolean getEstFrais() {
		return estFrais;
	}
	public void setEstFrais(boolean estFrais) {
		this.estFrais = estFrais;
	}

}

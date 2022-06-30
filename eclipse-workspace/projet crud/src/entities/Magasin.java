package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exception.MagasinPleinEmployeException;
import exception.MagasinPleinProduitException;

public class Magasin {
	private int id;
	private String nom;
	public static final int PRODUITS_MAX = 2;
	public static final int EMPLOYES_MAX = 20;
	private List<Produit> produits = new ArrayList<Produit>();
	private List<Employe> employes = new ArrayList<Employe>();

	//Méthodes
	public void addProduit(Produit p) {
		try {
			if(this.produits.size()<PRODUITS_MAX && (!(findInMagasin(p) )) ) {
				produits.add(p);
			} else {
				throw new MagasinPleinProduitException();
			}
		} catch (MagasinPleinProduitException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addEmploye(Employe e) {
		try {
			if(employes.size()<EMPLOYES_MAX && (!(employes.contains(e))) ) {
				employes.add(e);
			} else {
				throw new MagasinPleinEmployeException();
			}
			
		} catch (MagasinPleinEmployeException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	public Magasin(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public static Magasin maxProduitsMagasin (Magasin m1, Magasin m2) {
		if (m1.produits.size()>=m2.produits.size()) {
			return m1;
		}else {
			return m2;
		}
	}

	public boolean findInMagasin(Produit p) {
		return produits.contains(p);
	}
	
	public boolean deleteProduit(Produit p) {
		if (findInMagasin(p)) {
			produits.remove(p);
			return true;
		}
		else {
			return false;
		}
	}
	
	//Affichage
	public void afficheInfo() {
		String cleanId = ((this.id)==0) ? "" : Integer.toString(this.id);
		String cleanNom = (Objects.isNull(this.nom)) ? "" : this.nom;
		System.out.println("Id du magasin : "+cleanId);
		System.out.println("Nom du magasin : "+cleanNom+"\n");
	}
	
	public void afficheEmploye() {
		System.out.println("Liste des employes : ");
		for (Employe employe : employes) {
			employe.afficher();
		}
	}
	
	
	//Getters & setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}

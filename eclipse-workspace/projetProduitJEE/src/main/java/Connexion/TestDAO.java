package Connexion;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Produit;

public class TestDAO {
	public static void main(String[] args) {
		ProduitDAO dao = new ProduitDAO();
		ArrayList<Produit> produits = new ArrayList<Produit>();
		try {
			produits=dao.getAllProduits();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Produit produit : produits) {
			System.out.println(produit);
		}
		for (Produit produit : produits) {
			System.out.println(produit);
		}
	}
}

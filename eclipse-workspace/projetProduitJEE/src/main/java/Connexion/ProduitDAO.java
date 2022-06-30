package Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;

import entities.Produit;

public class ProduitDAO {
	private ConnexionMysql cnx = ConnexionMysql.getInstance();
	private Connection dba = cnx.getCnx();
	
	
	
	/**
	 * Selectionnes tous les produits et les renvoie sous forme d'un ResultSet, par ordre croissant de prix.
	 * @return La liste de tous les produits.
	 * @throws SQLException
	 */
	public ArrayList<Produit> getAllProduits() throws SQLException {
		Statement stmt=dba.createStatement();
		ResultSet res= stmt.executeQuery("SELECT * FROM produit");
		return resultSet2List(res);
	}
	
	/**
	 * Trouve un produit à partir de son id
	 * @param idToFind l'id du produit à chercher
	 * @return Le produit trouvé
	 * @throws SQLException
	 */
	public Produit getProduitById(int idToFind) throws SQLException {
		String query = "SELECT * FROM produit WHERE id=?";
		PreparedStatement stmt = dba.prepareStatement(query);
		stmt.setInt(1, idToFind);
		ResultSet res = stmt.executeQuery();
		res.next();
		int id = res.getInt("id");
		String designation = res.getString("designation");
		int prix = res.getInt("prix");
		int quantite = res.getInt("quantite");
		Produit p = new Produit(id,designation,prix,quantite);
		return p;
	}
	
	
	/**
	 * Supprime un produit de la base de donnée à partir du produit choisi en paramètre.
	 * 
	 * @param produit Le produit à supprimer de la base de données.
	 * @throws SQLException
	 * @throws ProductNotFoundException 
	 */
	public void deleteProduit(int idToDelete) throws SQLException {
		String query = "DELETE FROM Produit WHERE id=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setInt(1, idToDelete);
		int rowsDeleted = stmt.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("Produit d'id "+idToDelete+" supprimé");
		} else {
			System.out.println("Pas de produit trouvé");
		}
	}
	
	/**
	 * Ajoute un produit à la base de donnée à partir d'un produit choisi en paramètre.
	 * 
	 * @param produit Le produit à ajouter.
	 * @throws SQLException
	 */
	public void addProduit(Produit produit) throws SQLException {
		String query = "INSERT INTO Produit(id,designation,prix,quantite) VALUES (?,?,?,?)";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setInt(1, produit.getId());
		stmt.setString(2, produit.getDesignation());
		stmt.setInt(3, produit.getPrix());
		stmt.setInt(4, produit.getQuantite());
		stmt.executeUpdate();
	}
	
	/**
	 * Update un produit avec de nouvelles valeurs choisies en paramètre.
	 * 
	 * @param idToChange L'id du produit à modifier.
	 * @param designation La nouvelle description du produit.
	 * @param prix Le nouveau prix du produit.
	 * @param quantite La nouvelle quantite du produit.
	 * @throws SQLException
	 */
	public void updateProduit(int idToChange, String designation, int prix, int quantite) throws SQLException {
		String query = "Update Produit SET designation=?, prix=?, quantite=? WHERE id=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setString(1, designation);
		stmt.setInt(2, prix);
		stmt.setInt(3, quantite);
		stmt.setInt(4, idToChange);
		stmt.executeUpdate();
	}
	
	//Utils
	/**
	 * Transforme un ResultSet de produits en Liste de produits. 
	 * @param result le ResultSet à transformer.
	 * @return La liste des produits correspondant au ResultSet.
	 * @throws SQLException
	 */
	public ArrayList<Produit> resultSet2List(ResultSet result) throws SQLException {
		ArrayList<Produit> produits = new ArrayList<Produit>();
		int id;
		String designation;
		int prix;
		int quantite;
		while(result.next()) {
			id= result.getInt("id");
			designation= result.getString("designation");
			prix=result.getInt("prix");
			quantite=result.getInt("quantite");
			produits.add(new Produit(id,designation,prix,quantite));
		}
		return produits;
	}
	
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

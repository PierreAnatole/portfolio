package connexion;

import java.math.BigDecimal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Produit;
import exception.ProductNotFoundException;

/**
 * Classe permettant la manipulation de la table produit. 
 * Les m�thodes utilisant des requetes select renvoient des 
 * Listes stockant les produits correspondant.
 * @author PC31
 *
 */
public class ProduitDAO {
	private ConnexionPostgres cnx = ConnexionPostgres.getInstance();
	private Connection dba = cnx.getCnx();
	
	
	// AFFICHAGE
	/**
	 * Affiche toutes les informations d'une liste de produits.
	 * @param produits  La liste de produits � afficher.
	 */
	public void printAllFromList(ArrayList<Produit> produits) {
		//formatage de la premi�re ligne du tableau
		String entete = String.format("%15s %15s %15s %15s %15s\n", "id Produit", "libelle", "prix", "saison", "est frais");
		System.out.println(entete);
		
		for (Produit produit : produits) {
			System.out.print(produit);
		}
	}
	
	/**
	 * Affiche un produit � partir d'un ResultSet, en prenant en compte le nombre de colonnes.
	 * 
	 * @param produitsRes le ResultSet de produits.  
	 * @throws SQLException 
	 */
	public void printFromRes(ResultSet produitsRes) throws SQLException {
		//formatage de la premi�re ligne du tableau
		String[] columnsNames = getColumnNames(produitsRes);
		java.sql.ResultSetMetaData rsmd = produitsRes.getMetaData();
		int[] columnsTypes=getColumnTypes(produitsRes);
		
		String enteteFormat ="";
		for (int i = 0; i < columnsNames.length; i++) { // Pour chaque colonne on rajoute une entr�e pour le format
			enteteFormat+="%15s";
			if (i<(columnsNames.length-1)) {
				enteteFormat+=" ";
			}
		}
		enteteFormat+="\n";
		String entete = String.format(enteteFormat, columnsNames);
		System.out.println(entete); // affichage de l'ent�te.
		
		// pour chaque ligne du tableau :
		while(produitsRes.next()) {
			ArrayList<Object> values = new ArrayList<Object>(); // cr�er une liste d'objet pour stocker les valeurs.
			for (int i = 0; i < columnsTypes.length; i++) { // pour chaque nom de colonne :
				switch (columnsTypes[i]) { // on v�rifie le type de colonne et on ajoute sa valeur � values avec la bonne m�thode (getInt, getString etc).
				case java.sql.Types.VARCHAR:
					values.add(produitsRes.getString(columnsNames[i]));
					break;
				case java.sql.Types.DECIMAL:
					values.add(produitsRes.getBigDecimal(columnsNames[i]));
					break;
				case java.sql.Types.INTEGER:
					values.add(produitsRes.getInt(columnsNames[i]));
					break;
				case java.sql.Types.BIT:
					values.add(produitsRes.getBoolean(columnsNames[i]));
					break;

				default:
					break;
				}
			}
			Object[] valuesArr = values.toArray(new Object[0]); // On converti la liste en array pour l'utiliser comme param�tre  � la fonction String.format.
			System.out.print(String.format(enteteFormat, valuesArr)); // Afficher la ligne avec le bon formatage et la valeur de chaque colonne.
		}
		
	}
	
	// REQUETES
	/**
	 * Selectionnes tous les produits et les renvoie sous forme d'un ResultSet, par ordre croissant de prix.
	 * @return La liste de tous les produits.
	 * @throws SQLException
	 */
	public ResultSet produitsASC() throws SQLException {
		Statement stmt=dba.createStatement();
		ResultSet res= stmt.executeQuery("SELECT * FROM Produit ORDER BY prix ASC");
		return res;
	}
	
	/**
	 * Selectionnes tous les produits et les renvoie sous forme d'une liste de produits, par ordre d�croissant de prix.
	 * @return La liste de tous les produits.
	 * @throws SQLException
	 */
	public ResultSet listeProduitsDESC() throws SQLException {
		Statement stmt=dba.createStatement();
		ResultSet res= stmt.executeQuery("SELECT * FROM Produit ORDER BY prix DESC");
		return res;
	}
	
	public ResultSet selectAllFlex(String... nomsColonnes) throws SQLException {
		Statement stmt=dba.createStatement();
		String query = "SELECT ";
		for (int i = 0; i < nomsColonnes.length; i++) {
			query+=nomsColonnes[i];
			if (i<(nomsColonnes.length-1)) {
				query+=",";
			}
		}
		query+=" FROM Produit";
		ResultSet res= stmt.executeQuery(query);
		return res;	
	}
	
	/**
	 * Selectionne tous les produits correspondants � la saison entr�e en param�tre
	 * les renvoies sous forme de liste de produits. Equivalent � SELECT * FROM Produit WHERE saison = season.

	 * @param season La saison des articles choisis.
	 * @return La liste des produits correspondants.
	 * @throws SQLException
	 */
	public ResultSet produitsParSaison(String season) throws SQLException {
		String query = "SELECT * FROM Produit WHERE Produit.saison=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setString(1, season);
		ResultSet res= stmt.executeQuery();
		
		return res;
	}
	
	/**
	 * Update un produit avec de nouvelles valeurs choisies en param�tre.
	 * 
	 * @param produit Le produit � modifier.
	 * @param libelle Le nouveau libelle du produit.
	 * @param prix Le nouveau prix du produit en double.
	 * @param saison La nouvelle saison du produit.
	 * @param estFrais Le nouvel etat de fraicheur du produit.
	 * @throws SQLException
	 */
	public void updateProduct(Produit produit, String libelle, double prix, String saison, boolean estFrais) throws SQLException {
		int id = produit.getId();
		String query = "Update Produit SET libelle=?, prix=?, saison=?, estFrais=? WHERE idProduit=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setString(1, libelle);
		stmt.setBigDecimal(2, new BigDecimal(prix));
		stmt.setString(3, saison);
		stmt.setBoolean(4, estFrais);
		stmt.setInt(5, id);
		stmt.executeUpdate();
	}
	
	/**
	 * Supprime un produit de la base de donn�e � partir du produit choisi en param�tre.
	 * 
	 * @param produit Le produit � supprimer de la base de donn�es.
	 * @throws SQLException
	 * @throws ProductNotFoundException 
	 */
	public void deleteProduct(Produit produit) throws SQLException, ProductNotFoundException {
		int id = produit.getId();
		String query = "DELETE FROM Produit WHERE idProduit=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setInt(1, id);
		int rowsDeleted = stmt.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("Produit d'id "+id+" supprim�");
		} else {
			throw new ProductNotFoundException();
		}
	}

	// utils
	/**
	 * Transforme un ResultSet de produits en Liste de produits. 
	 * @param result le ResultSet � transformer.
	 * @return La liste des produits correspondant au ResultSet.
	 * @throws SQLException
	 */
	private ArrayList<Produit> resultSet2List(ResultSet result) throws SQLException {
		ArrayList<Produit> produits = new ArrayList<Produit>();
		int idProduit;
		String libelle;
		BigDecimal prix;
		String saison;
		boolean estFrais;
		while(result.next()) {
			idProduit= result.getInt("idProduit");
			libelle= result.getString("libelle");
			prix=result.getBigDecimal("prix");
			saison=result.getString("saison");
			estFrais=result.getBoolean("estFrais");
			produits.add(new Produit(idProduit,libelle,prix,saison,estFrais));
		}
		return produits;
	}
	
	/**
	 * Recup�re un produit � partir de son id si il existe. Sinon d�clenche une exception ProductNotFoundException.
	 * 
	 * @param id L'id du produit � trouver.
	 * @return Le produit d'id correspondant.
	 * @throws SQLException
	 * @throws ProductNotFoundException
	 */
	public Produit getProductById(int id) throws SQLException, ProductNotFoundException {
		ArrayList<Produit> produits = new ArrayList<Produit>();
		produits=resultSet2List(produitsASC());
		for (Produit produit : produits) {
			if (produit.getId()==id) {
				return produit;
			}
		}
		throw new ProductNotFoundException();
	}
	
	/**
	 * Renvoie le types des colonnes d'un ResultSet sous la forme d'un array d'int qui correspond aux types de l'enum java.sql.Types.
	 * 
	 * @param rs le ResultSet sur lequelle r�cuperer les types de colonnes.
	 * @return Un array contenant les noms des colonnes.
	 * @throws SQLException
	 */
	public String[] getColumnNames(ResultSet rs) throws SQLException {
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		String[] columns= new String[rsmd.getColumnCount()];
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			columns[i-1]=rsmd.getColumnName(i);
		}
		return columns;
	}
	
	public int[] getColumnTypes(ResultSet rs) throws SQLException {
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		int[] columns= new int[rsmd.getColumnCount()];
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			columns[i-1]=rsmd.getColumnType(i);
		}
		return columns;
	}
	
}

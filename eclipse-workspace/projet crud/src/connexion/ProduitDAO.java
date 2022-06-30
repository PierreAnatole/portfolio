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
 * Les méthodes utilisant des requetes select renvoient des 
 * Listes stockant les produits correspondant.
 * @author PC31
 *
 */
public class ProduitDAO {
	private ConnexionMysql cnx = ConnexionMysql.getInstance();
	private Connection dba = cnx.getCnx();
	
	
	// AFFICHAGE
	/**
	 * Affiche toutes les informations d'une liste de produits.
	 * @param produits  La liste de produits à afficher.
	 */
	public void printAllFromList(ArrayList<Produit> produits) {
		//formatage de la première ligne du tableau
		String entete = String.format("%15s %15s %15s %15s %15s\n", "id Produit", "libelle", "prix", "saison", "est frais");
		System.out.println(entete);
		
		for (Produit produit : produits) {
			System.out.print(produit);
		}
	}
	
	/**
	 * Affiche un produit à partir d'un ResultSet, en prenant en compte le nombre de colonnes.
	 * 
	 * @param produitsRes le ResultSet de produits.  
	 * @throws SQLException 
	 */
	public void printFromRes(ResultSet produitsRes) throws SQLException {
		//formatage de la première ligne du tableau
		String[] columnsNames = getColumnNames(produitsRes);
		int[] columnsTypes=getColumnTypes(produitsRes);
		
		String enteteFormat ="";
		for (int i = 0; i < columnsNames.length; i++) { // Pour chaque colonne on rajoute une entrée pour le format
			enteteFormat+="%15s";
			if (i<(columnsNames.length-1)) {
				enteteFormat+=" ";
			}
		}
		enteteFormat+="\n";
		String entete = String.format(enteteFormat, columnsNames);
		System.out.println(entete); // affichage de l'entête.
		
		// pour chaque ligne du tableau :
		while(produitsRes.next()) {
			ArrayList<Object> values = new ArrayList<Object>(); // créer une liste d'objet pour stocker les valeurs.
			for (int i = 0; i < columnsTypes.length; i++) { // pour chaque nom de colonne :
				switch (columnsTypes[i]) { // on vérifie le type de colonne et on ajoute sa valeur à values avec la bonne méthode (getInt, getString etc).
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
			Object[] valuesArr = values.toArray(new Object[0]); // On converti la liste en array pour l'utiliser comme paramètre  à la fonction String.format.
			System.out.print(String.format(enteteFormat, valuesArr)); // Afficher la ligne avec le bon formatage et la valeur de chaque colonne.
		}
		
	}
	
	// METHODES CRUD
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
	 * Selectionnes tous les produits et les renvoie sous forme d'une liste de produits, par ordre décroissant de prix.
	 * @return La liste de tous les produits.
	 * @throws SQLException
	 */
	public ResultSet produitsDESC() throws SQLException {
		Statement stmt=dba.createStatement();
		ResultSet res= stmt.executeQuery("SELECT * FROM Produit ORDER BY prix DESC");
		return res;
	}
	
	
	/**
	 * Selectionne les colonnes choisies de tous les produits et renvoie le resultSet correspondant. Chaque paramètre String correspond à une colonne du tableau que l'on souhaite afficher.
	 * 
	 * @param nomsColonnes Les noms de colonne que l'on veut afficher.
	 * @return Le resultSet correspondant à la requête.
	 * @throws SQLException
	 */
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
	 * Selectionne tous les produits correspondants à la saison entrée en paramètre
	 * les renvoies sous forme d'un ResultSet de produits. Equivalent à SELECT * FROM Produit WHERE saison = season.

	 * @param season La saison des articles choisis.
	 * @return Le ResultSet des produits correspondants.
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
	 * Update un produit avec de nouvelles valeurs choisies en paramètre.
	 * 
	 * @param produit Le produit à modifier.
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
	 * Supprime un produit de la base de donnée à partir du produit choisi en paramètre.
	 * 
	 * @param produit Le produit à supprimer de la base de données.
	 * @throws SQLException
	 * @throws ProductNotFoundException 
	 */
	public void deleteProduct(int id) throws SQLException, ProductNotFoundException {
		String query = "DELETE FROM Produit WHERE idProduit=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setInt(1, id);
		int rowsDeleted = stmt.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("Produit d'id "+id+" supprimé");
		} else {
			throw new ProductNotFoundException();
		}
	}
	
	/**
	 * Ajoute un produit à la base de donnée à partir d'un produit choisi en paramètre.
	 * 
	 * @param produit Le produit à ajouter.
	 * @throws SQLException
	 */
	public void addProduct(Produit produit) throws SQLException {
		String query = "INSERT INTO Produit(idProduit,libelle,prix,saison,estFrais) VALUES (?,?,?,?,?)";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setInt(1, produit.getId());
		stmt.setString(2, produit.getLibelle());
		stmt.setBigDecimal(3, produit.getPrix());
		stmt.setString(4, produit.getSaison());
		stmt.setBoolean(5, produit.getEstFrais());
		stmt.executeUpdate();
	}

	// utils
	/**
	 * Transforme un ResultSet de produits en Liste de produits. 
	 * @param result le ResultSet à transformer.
	 * @return La liste des produits correspondant au ResultSet.
	 * @throws SQLException
	 */
	public ArrayList<Produit> resultSet2List(ResultSet result) throws SQLException {
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
	 * Recupère un produit à partir de son id si il existe. Sinon déclenche une exception ProductNotFoundException.
	 * 
	 * @param id L'id du produit à trouver.
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
	 * Renvoie le nom des colonnes d'un ResultSet sous la forme d'un array de String.
	 * 
	 * @param rs le ResultSet sur lequelle récuperer les noms de colonnes.
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
	
	/**
	 * Renvoie le types des colonnes d'un ResultSet sous la forme d'un array d'int qui correspond aux types de l'enum java.sql.Types.
	 * 
	 * @param rs le ResultSet sur lequelle récuperer les types de colonnes.
	 * @return Un array d'int correspondant au type des colonnes d'après l'enum java.sql.Types.
	 * @throws SQLException
	 */
	public int[] getColumnTypes(ResultSet rs) throws SQLException {
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		int[] columns= new int[rsmd.getColumnCount()];
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			columns[i-1]=rsmd.getColumnType(i);
		}
		return columns;
	}
	
	/**
	 * Teste si un l'id d'un produit est présent ou non dans la base de données.
	 * 
	 * @param id L'idd à tester.
	 * @return true si l'id est présent dans la base de données, false sinon.
	 * @throws SQLException
	 */
	public boolean idExist(int id) throws SQLException {
		String query = "SELECT * FROM Produit WHERE Produit.idProduit=?";
		PreparedStatement stmt=dba.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet res= stmt.executeQuery();
		if(res.next()) {
			if (res.next()) {
				System.out.println("Le produit existe au moins en double");
				return false;
			}else {
				return true;
			}
		} else {
			return false;
		}
	}
	
}

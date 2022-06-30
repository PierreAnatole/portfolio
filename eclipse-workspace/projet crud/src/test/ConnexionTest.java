package test;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexion.ConnexionMysql;
import connexion.ProduitDAO;
import entities.Produit;
import exception.ProductNotFoundException;


public class ConnexionTest {
	public static void main(String[] args) throws SQLException, ProductNotFoundException {
		
		ProduitDAO PR = new ProduitDAO();
		Produit p = new Produit(15,"orange", 15.6,"AOUT",true);
		PR.printFromRes(PR.selectAllFlex("idProduit","saison","prix","prix"));
		
	}
	
}

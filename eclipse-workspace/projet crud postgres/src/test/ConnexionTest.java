package test;

import java.sql.SQLException;

import connexion.ProduitDAO;

public class ConnexionTest {
	public static void main(String[] args) throws SQLException {
		ProduitDAO PR = new ProduitDAO();
		
		PR.produitsASC();

		
	}
	
}

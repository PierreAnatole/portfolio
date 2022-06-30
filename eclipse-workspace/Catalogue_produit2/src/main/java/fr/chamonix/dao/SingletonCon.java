package fr.chamonix.dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class SingletonCon {
	
	private static Connection con;
	static {
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/catalogue_produits?" + "user=root&password=root");
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("nope");
		}
	}
	public static Connection getCon() {
		return con;
	}
	
	public static void main(String[] args) {
		SingletonCon Cn = new SingletonCon(); // création d'une instance qui ouvre une connexion vers la bdd
		Cn.getCon();
	}
	
	

}

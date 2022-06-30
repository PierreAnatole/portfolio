package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionMysql {
    public Connection cnx = null;
    private static ConnexionMysql instance;
    private ConnexionMysql(){
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    		catch (ClassNotFoundException e) {
    		System.out.println(e.getMessage());
    	}

        try {
            cnx =
               DriverManager.getConnection("jdbc:mysql://localhost/catalogue?" +
                                           "user=root&password=root");
            System.out.println("ok");
            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }

    }

    public Connection getCnx() {
        return cnx;
    }
   
    public static ConnexionMysql getInstance() {
    	if(instance==null) {
            instance=new ConnexionMysql();
        }
        return instance;
    }
    
    public static void main (String[] args) {
    	ConnexionMysql cn= new ConnexionMysql();//cree une instance qui ouvre une connex
    	cn.getCnx();
    }


}
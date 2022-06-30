package medical.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
	public Connection cnx = null;
    public ConnexionDB(){

    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		}
    		catch (ClassNotFoundException e) {
    		System.out.println(e.getMessage());
    		}
    	
        try {
            cnx =
               DriverManager.getConnection("jdbc:mysql://localhost/medical?" +
                                           "user=root&password=root");

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
    
    public static void main (String[] args) {
    	ConnexionDB cn= new ConnexionDB();//cree une instance qui ouvre une connex
    	cn.getCnx();
    }

}

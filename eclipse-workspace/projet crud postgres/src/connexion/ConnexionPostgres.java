package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionPostgres {
    public Connection cnx = null;
    private static ConnexionPostgres instance;
    private final String url = "jdbc:postgresql://localhost/bdmagasin?";
    private final String user ="postgres";
    private final String password = "root";
    
    private ConnexionPostgres(){

        try {
            cnx =
            	DriverManager.getConnection(url,user,password);
            	System.out.println("connexion ok");
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
   
    public static ConnexionPostgres getInstance() {
    	if(instance==null) {
            instance=new ConnexionPostgres();
        }
        return instance;
    }

}
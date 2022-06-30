package connexion;

import java.sql.Connection;

public class EmployeDAO {
	private ConnexionPostgres cnx = ConnexionPostgres.getInstance();
	private Connection dba = cnx.getCnx();
	
	
}

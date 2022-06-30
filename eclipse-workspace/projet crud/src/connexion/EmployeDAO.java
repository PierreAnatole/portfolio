package connexion;

import java.sql.Connection;

public class EmployeDAO {
	private ConnexionMysql cnx = ConnexionMysql.getInstance();
	private Connection dba = cnx.getCnx();
	
	
}

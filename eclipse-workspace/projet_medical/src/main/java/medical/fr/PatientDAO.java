package medical.fr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PatientDAO {

	ConnexionDB connexionMySql= new ConnexionDB();
	Statement ste=null;
	ResultSet rs=null;
	
	
	public PatientDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Patient> getAll() {
    	
		String req = "SELECT prenom, nom, email, telephone, id FROM patient"; 
		ArrayList<Patient> lp = new ArrayList<Patient>(); 
		Patient p; 
		
    	try {
    		ste= connexionMySql.getCnx().createStatement();
    		rs=ste.executeQuery(req);
    		while(rs.next()) {
    			p = new Patient();
    			p.setPrenom(rs.getString(1));
    			p.setNom(rs.getString(2));
    			p.setEmail(rs.getString(3));
    			p.setTelephone(rs.getString(4));
    			p.setId(rs.getInt(5));
    			
    			lp.add(p); 
    			//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
    		}
    	}catch(SQLException ex) {
    		System.out.println("erreur dans la requette sql"+ex.getMessage());
    	}
    	
    	return lp; 
    }

	public Patient get(int id) {
		// TODO Auto-generated method stub
		String req = "SELECT prenom, nom, email, telephone, id FROM patient WHERE id = "+ id; 
		
    	try {
    		ste= connexionMySql.getCnx().createStatement();
    		rs=ste.executeQuery(req);
    		Patient p = new Patient();
    		rs.next(); 
    		
   			
			p.setPrenom(rs.getString(1));
			p.setNom(rs.getString(2));
			p.setEmail(rs.getString(3));
			p.setTelephone(rs.getString(4));
			p.setId(rs.getInt(5));
    		
    		return p; 
    	}catch(SQLException ex) {
    		System.out.println("erreur dans la requette sql"+ex.getMessage());
    	}
    	
    	return null; 
	}
	
	public void remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		String req = "DELETE FROM patient WHERE id = "+ id; 
		
		ste= connexionMySql.getCnx().createStatement();
		int nbr = ste.executeUpdate(req);
		if (nbr != 0)
			System.out.println("Suppression effectuée avec succès");
	}

	public void createPatient(String prenom, String nom, String email, String telephone) {
		try {
			String req=""
					+ "INSERT INTO `patient` "
					+ "( `nom`, `prenom`, `email`, `telephone`, `ville`, `photo`, `adresse`, `date_naissance`) VALUES "
					+ "( ? , ? , ? , ? , NULL, NULL, NULL, NULL );"
					+ "";
			
			PreparedStatement ps = connexionMySql.getCnx().prepareStatement(
					req,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nom );
			ps.setString(2, prenom );
			ps.setString(3, email );
			ps.setString(4, telephone );
			
			ste= connexionMySql.getCnx().createStatement();
			
			//ste.executeUpdate(req);
			ps.executeUpdate(); 
			
			System.out.println("insertion reussi!");
		}catch(SQLException ex) {
			System.out.println("erreur dans la requette sql"+ex.getMessage());
		}
		
	}

	public void updatePatient(int id, String email, String telephone) {
		
		try {
			String req=""
					+ "UPDATE `patient` "
					+ "SET telephone = ? ,"
					+ "email =  ? "
					+ "WHERE id = ?;"
					+ "";
			
			PreparedStatement ps = connexionMySql.getCnx().prepareStatement(
					req,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, telephone );
			ps.setString(2, email );
			ps.setInt(3, id );
			
			ste= connexionMySql.getCnx().createStatement();
			
			//ste.executeUpdate(req);
			ps.executeUpdate(); 
			
			System.out.println("maj reussi!");
		}catch(SQLException ex) {
			System.out.println("erreur dans la requette sql"+ex.getMessage());
		}
		
	}

}

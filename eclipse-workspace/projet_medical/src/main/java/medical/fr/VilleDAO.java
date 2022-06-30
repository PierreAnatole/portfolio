package medical.fr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VilleDAO {

	ConnexionDB connexionMySql= new ConnexionDB();
	Statement ste=null;
	ResultSet rs=null;
	
	
	public ArrayList<Ville> getAll() {

        String req = "SELECT nom,code_postal FROM ville"; 
        ArrayList<Ville> lv = new ArrayList<Ville>(); 
        Ville p; 

        try {
            ste= connexionMySql.getCnx().createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()) {
                p = new Ville();
                p.setNom(rs.getString(1));
                p.setCodePostale(rs.getInt(2));
                lv.add(p); 
                //System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
        }catch(SQLException ex) {
            System.out.println("erreur dans la requette sql"+ex.getMessage());
        }

        return lv; 
    }

	public void createVille( String nom, int codePostale , String pays ) {
		try {
			String req=""
					+ "INSERT INTO `ville` "
					+ "( `nom`, `code_postal`, `pays`) VALUES "
					+ "( ? , ?, ?);"
					+ "";
			
			PreparedStatement ps = connexionMySql.getCnx().prepareStatement(
					req,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nom );
			ps.setInt(2, codePostale );
			ps.setString(3, pays );
			
			ste= connexionMySql.getCnx().createStatement();
			
			//ste.executeUpdate(req);
			ps.executeUpdate(); 
			
			System.out.println("insertion reussi!");
		}catch(SQLException ex) {
			System.out.println("erreur dans la requette sql"+ex.getMessage());
		}
		
	}
	
	
}

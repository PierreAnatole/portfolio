package fr.chamonix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.chamonix.entities.Produits;

public class ProduitDaoImp implements ProduitDaoable {

	@Override
	public Produits add(Produits p) {
		Connection con = SingletonCon.getCon();
		
		try {
			PreparedStatement pStatement = con.prepareStatement("insert into produits (designation,prix,quantite) values (?,?,?)");
			pStatement.setString(1, p.getDesignation());
			pStatement.setDouble(2, p.getPrix());
			pStatement.setInt(3, p.getQuantite());
			pStatement.executeUpdate();
			pStatement.close();
			
			PreparedStatement pStatement2 = con.prepareStatement("select MAX(id) as idMax from produits");
			ResultSet rSet = pStatement2.executeQuery();
			if (rSet.next()) {
				// get long prend comme param la colonne idMax qui est l'id le plus grand du dernier produit ajouté
				p.setId(rSet.getLong("idMax"));
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produits> findProductsBy(String KW) {
        List<Produits> poduitsList = new ArrayList<Produits>();
		Connection con = SingletonCon.getCon();
		
		try {
			PreparedStatement pStatement = con.prepareStatement("select * from produits where designation like ?");
			pStatement.setString(1, KW);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Produits p = new Produits();
				p.setId(rSet.getLong("id"));
				p.setPrix(0);
				p.setQuantite(0);				
				poduitsList.add(p);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return poduitsList;
		
	}

	@Override
	public Produits findProduit(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produits update(Produits P) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduit(long id) {
		// TODO Auto-generated method stub
		
	}

}

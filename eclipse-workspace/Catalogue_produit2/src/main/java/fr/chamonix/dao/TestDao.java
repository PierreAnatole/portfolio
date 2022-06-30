package fr.chamonix.dao;

import fr.chamonix.entities.Produits;

public class TestDao {
	
	public static void main(String[] args) {
	ProduitDaoImp pDao= new ProduitDaoImp();
	Produits p1 = pDao.add(new Produits("Ecran 27 HP",156,4));
	Produits p2 = pDao.add(new Produits("Ecran 24 HP",110,3));
	System.out.println(p1);
	System.out.println(p2);
	}
	
	

}

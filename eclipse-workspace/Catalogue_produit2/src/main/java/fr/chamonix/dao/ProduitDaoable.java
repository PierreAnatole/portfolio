package fr.chamonix.dao;

import java.util.List;

import fr.chamonix.entities.Produits;

public interface ProduitDaoable {
 public Produits add(Produits p); 
 public Produits findProduit(long id);
 public Produits update(Produits P);
 public void deleteProduit(long id);
 public List<Produits> findProductsBy(String KW);
}

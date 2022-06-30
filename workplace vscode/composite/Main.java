package composite;

public class Main {

    public static void main(String[] args) {
        Produit p1 = new Produit("Chaussure 1",10);
        Produit p2 = new Produit("Chaussure 2",7);
        Produit p3 = new Produit("Chaussure 3",1);
        Produit p4 = new Produit("pantalon 1",100);
        Produit p5 = new Produit("pantalon 2",110);
        Produit p6 = new Produit("Papiers de garantie",0);
        
        Boite b1 = new Boite("boite à chaussures 1",p1,p2,p3);
        Boite b2 = new Boite("boite à pantalons 2",p4,p5);
        Boite b3 = new Boite("Boite à Boite à vêtements",b1,b2);
        Boite carton = new Boite("carton de livraison",b3,p6);

        
        carton.afficheArbo();

        System.out.println("prix total : "+carton.getTotalPrice()); 
        


    }


}

package composite;

public class Produit implements Component{
    private String nom;
    private int prix ;
    private int depth;


    
    public Produit(String nom, int prix) {
        this.nom=nom;
        this.prix = prix;
    }

    public int getTotalPrice() {
        return prix;
    }

    @Override
    public void afficheTotalPrice() {
        System.out.println(getTotalPrice());
    }

    @Override
    public void parcoursArbo() {
        System.out.println(nom);
    }

    public void afficheArbo() {
        System.out.println(nom);
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    
}

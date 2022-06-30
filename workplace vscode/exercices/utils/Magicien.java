package exercices.utils;


public class Magicien extends Personne{


    public Magicien(String nomPers, String prenomPers, int agePers, int vie) {
        super(nomPers, prenomPers, agePers, vie);
        
    }

    private int experience = 1;
    private int vie = 50;

    public void attaque (Personne p) {
        p.setVie(p.getVie()-10);
    }
}

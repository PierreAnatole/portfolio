package exercices.utils;

import java.util.Scanner;

/**
 * Cette classe comporte 2 données membres : 1 tableau de types entiers et la taille du tableau.
 * 
 * Cette classe contient 3 méthodes (fonctions membres) :
 * 
 * Fonction saisie () qui crée le tableau suivant la taille de ce dernier et qui demande à l’utilisateur de remplir le tableau de nombres.
 * Fonction tri() qui trie le tableau.
 * Fonction affiche() qui affiche le tableau.
 * 
 */
public class TriNombre {
    
    private int[] entiers;
    private int taille;

    
    /**
     * Constructeur demandant la taille du tableau en paramètre pour initialiser l'instance de la classe TriNombre.
     * @param taille La taille du tableau de l'instance.
     */
    public TriNombre(int taille) {
        this.taille = taille;
    }

    /**
     * Demande à l'utilisateur de saisir des nombres pour remplir le tableau.
     */
    public void saisie() {
        Scanner sc = new Scanner(System.in);
        this.entiers = new int[this.taille];

        for (int i=0; i<taille; i++) {
            this.entiers[i]=sc.nextInt();
        }
    }

    /**
     * Affiche les élements du tableau.
     */
    public void affiche() {
        String res = "";

        res+="[";

        for (int i=0; i<this.taille; i++) {
            res+=Integer.toString(this.entiers[i]);
            if (i!=taille-1) {
                res+=",";
            }
        }

        res+="]";

        System.out.println(res);
    }

    /**
     * Trie le tableau par sélection.
     */
    public void tri() {
        Tableau.triSelec(this.entiers);
    }


}

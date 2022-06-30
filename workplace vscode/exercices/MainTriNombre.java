package exercices;

import exercices.utils.TriNombre;

public class MainTriNombre {
    public static void main(String[] args) {
        TriNombre triNombre1 = new TriNombre(4);
        TriNombre triNombre2 = new TriNombre(15);

        System.out.println("Saisissez les élements du premier tableau : ");
        triNombre1.saisie();
        System.out.println("Tableau 1 non trié : ");
        triNombre1.affiche();
        triNombre1.tri();
        System.out.println("Tableau 1 trié : ");
        triNombre1.affiche();
        
        
        System.out.println("\nSaisissez les élements du premier tableau : ");
        triNombre2.saisie();
        System.out.println("Tableau 2 non trié : ");
        triNombre2.affiche();
        triNombre2.tri();
        System.out.println("Tableau 2 trié : ");
        triNombre2.affiche();

    }
}

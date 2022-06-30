package exercices;
import exercices.utils.Cercles;

public class DesCercles {
    
    public static void main(String[] args) {
        // Création des deux cercles
        Cercles c1 = new Cercles(10);
        Cercles c2 = new Cercles(45);

        //calcul de la circonférence
        System.out.println("Circonférence de c1 : "+Cercles.round2(c1.calculCirconference()) +" cm");
        System.out.println("Circonférence de c2 : "+Cercles.round2(c2.calculCirconference())+" cm");
        
        //calcul de la surface
        System.out.println("\nSurface de c1 : "+Cercles.round2(c1.calculSurface())+" cm²");
        System.out.println("Surface de c2 : "+Cercles.round2(c2.calculSurface())+" cm²");

    }
}

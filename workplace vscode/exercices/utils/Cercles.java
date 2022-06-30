package exercices.utils;

public class Cercles {

    private static double PI = Math.PI;
    private double rayon;

    /**
     * Constructeur demandant le rayon du cercle pour l'initialiser.
     * @param rayon Le rayon du cercle à creér.
     */
    public Cercles(double rayon) {
        this.rayon = rayon;
    }

    /**
     * Calcule et renvoie la circonférence du cercle.
     * @return La circonférence du cercle.
     */
    public double calculCirconference(){
        
        return 2*PI*this.rayon;
    }

    /**
     * Calcule et renvoie la surface du cercle.
     * @return la surface du cercle.
     */
    public double calculSurface() {
        return PI*Math.pow(this.rayon, 2);
    }

    /**
     * Méthode statique permettant d'arrondir un double à 2 chiffres après la virgule.
     * @param d le double à arrondir.
     * @return Le double arrondi.
     */
    public static double round2 (double d) {
        return (double) Math.round( d* 100) / 100;
    }
    
}

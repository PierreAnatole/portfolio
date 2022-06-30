package figure.classes;

public class Rectangle extends Polygone{
    private double longeur;
    private double largeur;
    private final static int nbCote=4;

    /**
     * Calcule l'aire du rectangle.
     */
    @Override
    public double calculAire() {
        return this.longeur * this.largeur;
    }

    /**
     * Calcule le périmetre du rectangle.
     */
    @Override
    public double calculPerimetre() {
        return this.longeur*2 + this.largeur*2;
    }
    
}

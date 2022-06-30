package figure.classes;

public class Cercle extends Figure{

    public static final double PI = Math.PI;
    private double rayon;

    /**
     * Constructeur demandant le rayon du cercle pour l'initialiser.
     * @param rayon Le rayon du cercle à creér.
     */
    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    /**
     * Calcule et renvoie la circonférence du cercle.
     * @return La circonférence du cercle.
     */
    @Override
    public double calculPerimetre(){
        return (double)2*PI*this.rayon;
    }

    /**
     * Calcule et renvoie la surface du cercle.
     * @return la surface du cercle.
     */
    @Override
    public double calculAire() {
        return PI*Math.pow(this.rayon, 2);
    }
    
}

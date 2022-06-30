package exercices.utils;
import java.util.Objects;

public class Voiture {

    public final int nbRoues = 4;
    private String marqueVoiture;
    private float vitesseVoiture;
    private String couleurVoiture;
    private int ageVoiture;

    /**
     * Constructeur vide qui initialise tous les attributs numériques à 0 et tous les attributs chaine de caractère à null.
     */
    public Voiture() {
        
    }

    /**
     * Constructeur demandant toutes les informations liées à la voiture.
     * @param marqueVoiture La marque de la voiture.
     * @param vitesseVoiture La vitesse de la voiture.
     * @param couleurVoiture La couleur de la voiture.
     * @param ageVoiture L'age de la voiture.
     */
    public Voiture(String marqueVoiture, float vitesseVoiture, String couleurVoiture, int ageVoiture) {
        this.marqueVoiture = marqueVoiture;
        this.vitesseVoiture = vitesseVoiture;
        this.couleurVoiture = couleurVoiture;
        this.ageVoiture = ageVoiture;
    }
    
    @Override
    public String toString() {
        // formate en chaine de caractère chacun des attributs, si une valeur n'est pas connue, "inconnu" est affiché.
        String m = Objects.isNull(this.marqueVoiture) ? "inconnue" : this.marqueVoiture;
        String v = (this.vitesseVoiture==0.0) ? "inconnue" : Float.toString(this.vitesseVoiture)+"km/h";
        String c = Objects.isNull(this.couleurVoiture) ? "inconnue" : this.couleurVoiture;
        String a = (this.ageVoiture==0) ? "inconnu" : Integer.toString(this.ageVoiture)+" an"+((this.ageVoiture>1)?"s":""); // Pluriel si la voiture à plusieurs années.

        return "marque : "+m+"\nvitesse : "+v+"\ncouleur : "+c+"\nage : "+a;
    }

    /**
     * Ajoute 15 km/h à la vitesse de la voiture
     */
    public void accelerer15() {
        this.vitesseVoiture+=15;
    }

    /**
     * Ajoute 10 ans à l'age de la voiture
     */
    public void viellir10() {
        this.ageVoiture+=10;
    }

    /**
     * Vérifie si la voiture est trop vielle.
     * @return true si l'age de la voiture est supérieur à 15, false sinon.
     */
    public boolean isTooOld() {
        return this.ageVoiture>15;
    }
    
    
    //GETTERS / SETTERS

    /**
     * Renvoie l'age de la voiture
     * @return l'age de la voiture
     */
    public int getAgeVoiture() {
        return ageVoiture;
    }

    /**
     * Renvoie le nombre de roues de la voiture
     * @return le nombre  de roues de la voiture
     */
    public int getNbRoues() {
        return nbRoues;
    }
    
    /**
     * Renvoie la vitesse de la voiture
     * @return la vitesse de la voiture
     */
    public float getVitesseVoiture() {
        return vitesseVoiture;
    }

}
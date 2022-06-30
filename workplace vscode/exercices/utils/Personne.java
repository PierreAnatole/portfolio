package exercices.utils;

/**
 * Classe modélisant une personne avec son nom, son prénom et son age.
 */
public class Personne {
    private String nomPers;
    private String prenomPers;
    private int agePers;
    private int vie;

    /**
     * Constructeur permettant d'initialiser le nom, le prénom et l'age de la personne créee.
     * .
     * @param nomPers Le nom de la personne à créér.
     * @param prenomPers Le prénom de la personne à créér.
     * @param agePers L'age de la personne à créer..
     */
    public Personne(String nomPers, String prenomPers, int agePers, int vie) {
        this.nomPers = nomPers;
        this.prenomPers = prenomPers;
        this.agePers = agePers;
        this.vie = vie;
    }

    /**
     * Affiche l'age de la personne et la retourne.
     * @return L'age de la personne.s
     */
    public int afficheAge() {
        System.out.println(this.agePers);
        return this.agePers;
    }

    /**
     * Modifie l'age de la personne avec l'age choisi en paramètre.
     * @param agePers Le nouvel age de la personne.
     */
    public void changerAge(int agePers) {
        this.agePers = agePers;
    }

    @Override
    public String toString() {
        this.nomPers = nomPers;
        this.prenomPers = prenomPers;
        this.agePers = agePers;
        this.vie = vie;
        return "nom : "+ this.nomPers+"\nprénom : "+this.prenomPers+"\nage : "+this.agePers+"\nvie : "+this.vie;
    }

    //GETTER ET SETTERS
    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    public String getPrenomPers() {
        return prenomPers;
    }

    public void setPrenomPers(String prenomPers) {
        this.prenomPers = prenomPers;
    }

    public int getAgePers() {
        return agePers;
    }

    public void setAgePers(int agePers) {
        this.agePers = agePers;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }
    

    
}

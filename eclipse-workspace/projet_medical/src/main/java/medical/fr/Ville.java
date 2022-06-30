package medical.fr;

public class Ville {
    
    private int id;
    private String nom;
    private int codePostale;
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getCodePostale() {
        return codePostale;
    }


    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }


    @Override
    public String toString() {
        return "Ville [nom=" + nom + ", code_postal=" + codePostale + "]";
    }


    public Ville() {
        
    }

}

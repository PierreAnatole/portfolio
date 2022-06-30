package entities;

import java.util.Objects;

public abstract class Employe {
	protected int id;
	protected String nom;
	protected String adresse;
	protected int nbHeureMois;
	
	//Affichage
	public void afficher() {
		String cleanId = ((this.id)==0) ? "" : Integer.toString(this.id);
		String cleanNom = (Objects.isNull(this.nom)) ? "" : this.nom;
		String cleanAdresse = (Objects.isNull(this.adresse)) ? "" : this.adresse;
		String cleanNbHeure = ((this.nbHeureMois)==0) ? "" : Integer.toString(this.nbHeureMois);
		System.out.println("Id de l'employe : "+cleanId);
		System.out.println("Nom de l'employe : "+cleanNom);
		System.out.println("Adresse: de l'employe"+cleanAdresse); 
		System.out.println("nombre d'heures de l'employe : "+cleanNbHeure+"\n"); 
	}
	
	public abstract double calculeSalaire();
}

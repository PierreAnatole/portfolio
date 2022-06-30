package exercices;
import exercices.utils.Magicien;
import exercices.utils.Personne;
import exercices.utils.Sorcier;
import exercices.utils.Voiture;

public class MainObj {
    
    public static void main(String[] args) {
        // Voiture v = new Voiture();
        // Voiture v1 = new Voiture("Vroom Vroom", 120, "bleu",1);
        // Voiture v2 = new Voiture("Tut Tut", 130, "rouge",2);
        // Voiture v3 = new Voiture("Pwet Pwet", 180, "noir",3);

        // System.out.println("voiture v :\n"+v+"\n");
        // System.out.println("voiture 1 :\n"+v1+"\n");
        // System.out.println("voiture v2 :\n"+v2+"\n");
        // System.out.println("voiture v3 :\n"+v3+"\n");

        // System.out.println("nombre de roues de v : "+v.getNbRoues());
        // System.out.println("nombre de roues de v2 : "+v2.getNbRoues());

        // System.out.println("\nvitesse de v3 : "+v3.getVitesseVoiture());
        // v3.accelerer15();
        // System.out.println("vitesse de v3 : "+v3.getVitesseVoiture());
        // v3.accelerer15();
        // System.out.println("vitesse de v3 : "+v3.getVitesseVoiture());

        // System.out.println("\nage de v3 : "+v3.getAgeVoiture());
        // System.out.println("La voiture v3 est-elle trop vielle ? : "+ (v3.isTooOld()?"oui":"non") );
        // v3.viellir10();
        // System.out.println("\nage de v3 : "+v3.getAgeVoiture());
        // System.out.println("La voiture v3 est-elle trop vielle ? : "+ (v3.isTooOld()?"oui":"non") );
        // v3.viellir10();
        // System.out.println("\nage de v3 : "+v3.getAgeVoiture());
        // System.out.println("La voiture v3 est-elle trop vielle ? : "+ (v3.isTooOld()?"oui":"non") );

        Personne[] tabPersonne = new Personne[5];
        for (int i = 0; i < tabPersonne.length; i++) {
            if(i%2==0) {
                tabPersonne[i]=new Magicien("merlin "+i, "l'enchanteur", 50+i, 80+i);
            }
            else {
                tabPersonne[i] = new Sorcier("sorcier "+i, "prenom", 666, 666+i*2);
            }
        }

        for (int i = 0; i < tabPersonne.length; i++) {
            System.out.println(tabPersonne[i]);
        }

        
    }

}

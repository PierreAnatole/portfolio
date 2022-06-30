package figure.point;


/*2) Écrire une méthode main (à mettre dans la classe Point ou dans une autre classe TestPoint) qui : 
Construit un point de coordonnées 3.5 et 7 
Affiche les coordonnées de ce point 
Déplace ce point de 2 et 3 
Réaffiche les coordonnées du point *
*/
public class Main {
    public static void main(String[] args) {

        Segment s = new Segment(4,7,7,3);
        System.out.println(s.getLongueur());    }
}

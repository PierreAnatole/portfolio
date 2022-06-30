package animal;

import animal.classes.*;


public class MainAnimal {
    public static void main(String[] args) {
        // System.out.println("Nombre animaux vivants : " +Animal.getNombreAnimauxVivants());
        
        // Vache v = new Vache(1);
        // System.out.println("Nombre animaux vivants : "+Animal.getNombreAnimauxVivants());
        
        // v.vieillir();
        // System.out.println("age de la vache : "+v.getAge());
        // v.vieillir();
        // System.out.println("age de la vache : "+v.getAge());
        // v.vieillir();

        
        // System.out.println("Nombre animaux vivants : "+Animal.getNombreAnimauxVivants());

        Vache v2 = new Vache(0);
        v2.addToTab();

        System.out.println(v2.getTabVache().get(0));
        

        
    }
}

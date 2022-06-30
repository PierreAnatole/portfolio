package exercices.utils;

public class TimeManipulation {

    /**
    * Retourne le nombre de secondes correspondant à la durée en heure, minute et seconde entrée en paramètre.
    * 
    * @param h le nombre d'heure, h>=0
    * @param m le nombre de minutes, 0<=m<=59
    * @param s nombre de secondes, 0<=m<=59
    * @return la durée totale, exprimée en secondes
    */
    public static int castHMS2S(int h, int m, int s) {
        return(60*60*h+60*m+s);
    }

    /**
    * Affiche en format h min s la duree en secondes passée en paramètre.
    * 
    * @param duree La duree en secondes à formater et afficher sous la forme h min s. duree > 0
    */
    public static void afficheHMS(int duree) {
        int heures=duree/3600; // Nombre de fois que duree contient 3600 secondes donc nombre d'heure.
        int minutes=(duree/60)%60; // duree/60 correspond au nombre de minutes. On récupère le modulo 60 du résultat car les heures sont déja stockées dans heures.
        int secondes=duree%60; // Nombre de secondes modulo 60 car les heures et les minutes sont stockées dans heures et minutes.

        // secAddZero et minAddZero ajoutent un 0 derrière le nombre de seconde ou minute pour forcer un affichage à deux chiffres si necessaire.
        String secAddZero = (secondes<10) ? "0" : "";
        secAddZero+=Integer.toString(secondes);
        String minAddZero = (minutes<10) ? "0" : "";
        minAddZero+=Integer.toString(minutes);
        
        
        if (secondes>0) { // Affiche toutes les données
            System.out.println(heures+"h "+minAddZero+"m "+secAddZero+"s");
        } else if (minutes>0) { // N'affiche pas les secondes si il y en a pas
            System.out.println(heures+"h "+minAddZero+"m");
        } else { // N'affiche ni les secondes ni les minutes si il y en a pas
            System.out.println(heures+"h");
        }
    }

}

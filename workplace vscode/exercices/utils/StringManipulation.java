package exercices.utils;

public class StringManipulation {

    /**
     * Compte le nombre d'occurence de toFind dans la chaine de caractère s.
     * 
     * @param s La chaine de caractère à tester.
     * @param toFind La chaine de caractère à trouver dans s.
     * @return Le nombre d'occurence de toFind dans s.
     */
    public static int countInStr (String s, String toFind) {
        String res=s;
        int cpt=0;
        while(res.indexOf(toFind)!=-1) {
            cpt++;
            res=res.substring(res.indexOf(toFind)+1);
        }
        return cpt;
    }

    /**
     * Compte et affiche le nombre de mots dans une phrase. Un mot est séparé par un espace ou par un "'". plusieurs espaces à la suite représentent plusieurs mots.
     * @param s La chaine de caractère à tester?*.
     */
    public static void compteMotDansPhrase(String s) {
        System.out.println(countInStr(s, " ")+countInStr(s, "'")+1);
    }

    /**
     * Concatène un tableau de chaines de caractère en une chaine de caractère.
     * 
     * @param chaines Le tableau de chaines de caractères à concaténer.
     * @return La chaine de caractère correspondant à la concaténation des chaines du tableau.
     */
    public static String concatChaine(String[] chaines) {
        String res="";
        for (int i=0; i<chaines.length; i++) {
            res+=chaines[i];
        }
        return res;
    }

    




}

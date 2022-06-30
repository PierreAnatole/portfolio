package exercices.utils;

public class Tableau {
    /**
     * Initialise et renvoie un tableau d'integer de taille n.
     * 
     * @param n La taille du tableau à initialiser. n > 0
     * @return Le tableau initialisé
     */
    public static int[] initTab(int n)  {
        int[] tab = new int[n];

        for (int i=0; i<n; i++) {
            tab[i]=i+1;
        }

        return tab;
    }

    /**
     * Affiche de manière lisible un tableau d'int puis effectue un saut de ligne.
     * 
     * @param tab Le tableau à afficher.
     */
    public static void readTab(int[] tab){
        System.out.print("[");

        for (int i=0; i<tab.length; i++) {
            System.out.print(tab[i]);
            if (i!=tab.length-1) {
                System.out.print(",");
            }
        }

        System.out.print("]");
        System.out.println("");
    }

    /**
     * Affiche de manière lisible un tableau de chaines de caractères puis effectue un saut de ligne.
     * 
     * @param tab Le tableau à afficher.
     */
    public static void readTab(String[] tab){
        System.out.print("[");

        for (int i=0; i<tab.length; i++) {
            System.out.print(tab[i]);
            if (i!=tab.length-1) {
                System.out.print(",");
            }
        }

        System.out.print("]");
        System.out.println("");
    }

    /**
    * Permute entre eux deux élements d'indice x et y du tableau tab. Le tableau est modifié par effet de bord.
     * 
     * @param tab Le tableau sur lequel effectuer la permutation.
     * @param x L'indice du premier élement à permuter. 0 <= x <= tab.length-1
     * @param y L'indice du deuxieme élement à permuter. 0 <= y <= tab.length-1
     */
    public static void permutTab(int[] tab, int x, int y) {
        int temp = tab[x];
        tab[x]=tab[y];
        tab[y]=temp;
    }

    /**
     * Permute entre eux deux à deux les elemnts d'un tableau. Si le tableau est de taille impair le dernier élément n'est pas permuté.
     * Le tableau est modifié  par effet de bord.
     * 
     * @param tab Le tableau sur lequel effectuer la permutation.
     */
    public static void permutAll(int[] tab) {
        for (int i=1; i<tab.length; i+=2) {
            permutTab(tab, i, i-1);
        }
    }

    /**
     * Compte le nombre de fois que la valeur value apparait dans le tableau.
     * 
     * @param tab Le tableau sur lequel chercher les valeurs.
     * @param value La valeur à compter dans le  tableau.
     * @return Le nombre de fois que value apparait dans le tableau.
     */
    public static int countValueInTab(int[] tab, int value) {
        int nbOccu=0; // compteur indiquant le nombre de fois que value apparait dans tableau
        for (int i=0; i<tab.length; i++) {
            if (tab[i]==value) {
                nbOccu++;
            }
        }
        return nbOccu;
    }

    /**
     * Prend un tableau d'exactement 3 chaines de caractères correspondant à des entiers et renvoie true si 
     * tab[0]²+tab[1]²==tab[2]² est vrai.
     * 
     * @param tab Un tableau de 3 chaines de caractères.
     * @return true si l'equation est vérifiée, sinon renvoie false.
     */
    public static boolean isRectangle(String[] tab) {
        // Conversion en int des trois arguments.
        int a = Integer.parseInt(tab[0]);
        int b = Integer.parseInt(tab[1]);
        int c = Integer.parseInt(tab[2]);

        // vérification de l'equation.
        if (Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2)) {
            return true;
        }
        return false;
    }

    /**
     * Renvoie un tableau d'integer correspondant au tableau de chaines de caractère entré en paramètre.
     * 
     * @param strTab Un tableau de chaines de caractères contenant exclusivement des chiffres décimaux, le premier caractère peut être un - pour
     * indiquer un nombre négatif.
     * 
     * @return Un tableau d'integer correspondant au tableau de chaines de caractère.
     */
    public static int[] stringArray2IntArray(String[] strTab) {
        int[] intTab = new int[strTab.length]; // Initialisation du tableau

        for (int i=0; i<strTab.length; i++) {
            intTab[i]=Integer.parseInt(strTab[i]); // Conversion des éléments du tableau
        }

        return intTab;
    }

    /**
     * Transorme une chaine de caractère en un tableau, chaque élement du tableau correspond à 
     * une partie de la chaine de caractère, séparé par un délimiteur choisi par l'utilisateur.
     * 
     * @param s La chaine de caractère à transformer.
     * @param delimiter Le délimiteur.
     * @return Le tableau correspondant.
     */
    public static String[] tokenizeStr(String s, String delimiter) {
        String res=s;
        int cpt=0;
        String[] strTab= new String[StringManipulation.countInStr(res, delimiter)+1];

        while(res.indexOf(delimiter)!=-1) {
            strTab[cpt]=res.substring(0, res.indexOf(delimiter));
            res=res.substring(res.indexOf(delimiter)+1);
            cpt++;
        }
        strTab[cpt]=res;

        return strTab;
    }

    /**
     * Prend un chaine de caractère séparés de 3 élements séparés par deux ';'. Les chaines de caractères correspondant à des entiers et renvoie true si 
     * tab[0]²+tab[1]²==tab[2]² est vrai.
     * @param s La chaine de caractère contenant les 3 arguments
     * @return true si l'equation est vérifiée, sinon renvoie false.
     */
    public static boolean isRectangleFromStr (String s) {
        return isRectangle(tokenizeStr(s, ";"));
    }

    /**
     * Effectue un tri par séléction sur le tableau par effet de bord.
     * 
     * @param tab Le tableau à trier.
     */
    public static void triSelec(int[] tab) {
        int min; //Minimum local de la partie droite (non triée) du tableau
        int indexToSwap; //l'indice du minimum local.
        for (int i=0; i<tab.length; i++) {// boucle permettant d'initialiser le minimum et son indice et permet d'incrémenter le départ de la deuxième boucle.
            min=tab[i];
            indexToSwap=i;
            for (int j=i+1; j<tab.length; j++) { //Boucle permettant de parcourir la partie droite (non triée) du tableau
                if (tab[j]<min) {
                    min=tab[j]; //Sauvegarde du minimum local de la partie droite (non triée) du tableau
                    indexToSwap=j; //Sauvegarde de l'indice du minimum local.
                }
            }
            permutTab(tab, i, indexToSwap); // Echange par effet de bord l'indice du premier élement de la partie non triée du tableau avec son élement le plus petit.
        }
    }
}

package exercices.utils;

import java.util.*;

import exercices.NegativeNumberException;


public class Exo {

    public static void helloWorld () {
        String text ="";
        text+="hello";
        text+=" ";
        text+="world";
        System.out.println(text);
    }

    public static void testVar () {
        // int valeur = 10;
        // long nombre;
        // int compteur;
        // String texte;
        // int jour, mois, annee;
        // int[] tab = new int[10];
        // int[] tab2;
        // tab2 = new int[10];

        // for (int i = 0; i < 10; i++) {
        //     //...
        // }

        // int[] tab3 = new int[10];
        // tab3[0] = 5;
        // System.out.println(tab3[1]);
    }

    public static void entier () {
        System.out.println("Entrez un chiffre :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    public static void interval() {
        int min = 10;
        int max = 20;
        int res = 0;
        for (int i = min; i <= max; i++) {
            res+=i;
        }
        System.out.println(res);
    }

    public static void testCast() {
        // byte by = 127;
        // System.out.println(by);

        // short sh = (short)by;
        // System.out.println(sh);

        // int i = (int)sh;
        // System.out.println(i);

        // long l = (long)i;
        // System.out.println(l);

        // float f = (float)l;
        // System.out.println(f);

        // double d = (double)f;
        // System.out.println(d);

        int i = 120;
        byte b = (byte)i;
        System.out.println(b);
    }

    public static void testScanRand () {
        Random r = new Random();
        int a = r.nextInt()%10;
        System.out.println(a);
        a = r.nextInt()%10;
        System.out.println(a);
        a = r.nextInt()%10;
        System.out.println(a);
        
        Scanner sc = new Scanner(System.in);
        int entier = sc.nextInt();
        sc.close();
        System.out.println("la valeur de entier est : "+entier);
    }

    public static void scanInterval () {
        Scanner sc = new Scanner(System.in);
        int res=0;
        System.out.println("Saisissez la borne inférieure n1 : ");
        int n1 = sc.nextInt();
        System.out.println("Saisissez la borne supérieure n2 : ");
        int n2 = sc.nextInt();
        sc.close();

        for (int i = n1; i <= n2; i++) {
            res+=i;
        }
        
        System.out.println("Somme des nombres entre n1 et n2 : "+res);

        int res2 = (((n1+n2))*(n2-n1+1)/2);
        System.out.println("res2 : "+res2);
    }

    public static void minMax () {
        Scanner sc = new Scanner (System.in);
        int somme = 0;
        int cpt=0;
        System.out.println("Entrez un chiffre au clavier, arretez la saisie en entrant 0 :");
        int inp = sc.nextInt();
        int min=inp;
        int max=inp;
        while (inp!=0) {
            if (inp<min) {
                min=inp;
            }
            
            if (inp>max) {
                max=inp;
            }

            somme+=inp;
            cpt++;
            System.out.println("Entrez un chiffre au clavier, arretez la saisie en entrant 0 :");
            inp = sc.nextInt();
        }
        sc.close();
        
        System.out.println("Somme : "+somme);
        System.out.println("Moyenne : "+((float)somme/cpt));
        System.out.println("Min : "+min);
        System.out.println("Max : "+max);
    }

    public static void parite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un nombre :");
        int n = sc.nextInt();
        sc.close();
        String msg = n%2==0 ? "Le nombre "+n+" est pair"  : "Le nombre "+n+" est impair";
        System.out.println(msg);
    }

    public static void remise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le prix unitaire du produit :");
        float PU = sc.nextInt();
        System.out.println("Entrez la quantité de produit commandée :");
        float QTE = sc.nextInt();
        sc.close();
        float TOT;
        float PAP;
        float PORT=0;
        float REM;

        TOT = PU*QTE;
        
        // PORT
        if (TOT>500) {
            PORT=0;
        }
        else {
            PORT = TOT/100*2;
            if (PORT<6) {
                PORT=6;
               
            }
        }

        // REMISE
        if (TOT>200) {
            REM=10;
        }
        else if (TOT>100) {
            REM = 5;
        }
        else {
            REM=0;
        }

        PAP=TOT*((100-REM)/100)+PORT;

        System.out.println("Prix total à payer : "+PAP+" Euros");
        System.out.println("Frais de port  : "+PORT+" Euros");
        System.out.println("Remise en % : "+REM+"%");
    }

    

    public static void testToString () {
        
        
        // byte by = 127;
        // by.toString();

        // short sh = 10;
        // sh.toString();

        // int i = 10;
        // i.toString();

        // long l = 10;
        // l.toString();

        // float f =10;
        // f.toString();

        // double d = (double)f;
        // d.toString();

        // char c = "1";
        // c.toString();

        // boolean b = true;
        // b.toString();
        
        int[] t=  {4,5,6};
        System.out.println(t.toString());
    }

    
    public static void tableaux() {
        int taille = 5;
        int[] tab = new int[taille];
        
        for (int i=0; i<taille; i++) {
            tab[i]=i+1;
        }
    }

    /**
     * Teste en boucle un input utilisateur jusqu'a ce que l'input soit un int valide.
     * 
     * @return L'int entré par l'utilisateur.
     */
    public static int tryIntInput() {
        // flag permettant de rester dans la boucle tant que le try n'est pas executé.
        boolean tryInputFlag = true;
        int inputUtilisateur = 0;
        while (tryInputFlag) {
            try {
                // création du scanner dans le try pour créer un nouveau token sinon le scanner lit le même input en boucle.
                inputUtilisateur = new Scanner(System.in).nextInt();
                tryInputFlag=false;
            } catch (Exception e) {
                System.out.println("Input invalide : entrez un nombre");
            }
        }
        return inputUtilisateur;
    }
    

    /**
     * Déclenche le jeu nombre magique. Vous devez trouver un nombre entre 1 et la borne max définie en paramètre, la console vous aide
     * en indiquant si le nombre mystère est plus grand ou plut petit que le nombre que vous venez d'essayer. Vous pouvez abandonner à
     * tout moment en tapant 0.
     * 
     * @param max La borne maximale du nombre mystère.
     */
    public static void nombreMystere(int max) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // Initialisation du nombre mystère entre 1 et max.
        int nMyst = 1+r.nextInt(max-1);
        // Initialisation du nombre choisi par l'utilisateur
        int inputUtilisateur;
        System.out.println("Trouvez un nombre entre 1 et "+max+", abandonnez en tapant 0." );
        // initialisation du compteur d'essais
        int nbEssai=0;
        
        do {
            // Demande un nombre à l'utilisateur grace à la fonction tryIntInput qui force l'utilisateur à entrer un input de type int.
            inputUtilisateur=tryIntInput();

            nbEssai++;
            if (inputUtilisateur<nMyst) {
                System.out.println("C'est plus grand");
            }
            else if (inputUtilisateur>nMyst) {
                System.out.println("C'est plus petit");
            }
        } while ((inputUtilisateur!=nMyst)&&(inputUtilisateur!=0)); //Tant que le nombre n'est pas trouvé et l'utilisateur n'a pas abandonné, réiterer.
        if (inputUtilisateur==0) { //En cas d'abandon
            System.out.println("Vous avez abandonné....");
            System.out.println("Le resultat était : "+nMyst);
        } else { // en cas de victoire
            System.out.println("Oui bravo, vous avez trouvé en "+nbEssai+" coups.");
        }

        sc.close();
    }

    /**
     * Affiche les nombre de 1 à la valeur max passée en paramètre en remplacant les multiples de 3 par "Fizz!", les
     * multiples de 5 par "Buzz!" et les multiples de 3 et 5 par "FizzBuzz!".
     * 
     * @param max La valeur maximale affichée par la fonction. max > 0
     */
    public static void fizzBuzz(int max) {

        for (int i=1; i<=max; i++) {
            if ((i%3==0)&&(i%5==0)) { // Affiche fizzbuzz! si i est un multiple de 3 et 5
                System.out.println("FizzBuzz!");
            }
            else if (i%3==0) { // Affiche Fizz! si i est un multiple de 3 mais pas de 5
                System.out.println("Fizz!");
            }
            else if (i%5==0) { // Affiche Buzz! si i est un multiple de 5 mais pas de 3
                System.out.println("Buzz!");
            }
            else { // Sinon affiche i
                System.out.println(i);
            }
        }

    }

    /**
     * Teste si le nombre entré en paramètre est positif, sinon lance une exception.
     * 
     * @param s Le nombre à  tester
     * @throws NegativeNumberException
     */
    public static void controlPositiveNumber(int s) throws NegativeNumberException{
        if (s<0) {
            throw new NegativeNumberException("Erreur personalisée : le nombre doit être positif");
        }
    }

    /**
     * Demande un input à l'utilisateur et vérifie que  le nombre est positif
     */
    public static void testCustomEx() {

        try {
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            sc.close();
            controlPositiveNumber(userInput);   
        } catch (NegativeNumberException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("Rentrez un input valide");
        }

    }

    /**
     * Renvoie le nombre d'étapes nécessaire pour terminer la suite de syracuse avec le nombre choisi par l'utilisateur. 
     * La fonction affiche aussi chaque étapes de la suite.
     *  
     * @param number Le nombre initial pour commencer la suite.
     * @return Le nombre d'étapes requises pour terminer la suite.
     */
    public static int syracuse(int number) {
        if(number==1) {
            return 0;
        }
        int n=number;
        int cpt=1;
        System.out.println("Initialisation : n="+n);
        do {
            if(n%2==0) { // si n est pair alors :
                n/=2; // diviser n par deux.
                System.out.println("étape n°"+(cpt)+" : n="+n);
            }
            else if(n%2==1) {// si n est impair alors :
                n*=3; //multiplier n par 3.
                n++; //ajouter 1 à n.
                System.out.println("étape n°"+(cpt)+" : n="+n);
            }
            cpt++;
        } while (n!=1);  

        cpt-=1;
        return cpt;
    }

    

}
package entities;
import javax.swing.JPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

/**
 * Classe représentant un symbole. Un symbole est construit d'après son phonème ainsi qu'un tableau de lignes.
 * 
 * <p>
 * l'attribut pho contient le phonème du symbole.
 * l'attribut ll est la liste des lignes.
 * </p>
 * 
 * <p>
 * La méthode paint est une redéfinition de Jpanel. elle s'execute automatiquement via d'autres classes.
 * </p>
 */
public class Symbol extends JPanel{
    public Phoneme pho;
    public ArrayList<Ligne> listLigne = new ArrayList<>();
    public boolean circle;
    
    
    
    // Constructeurs

    /**
     * Constructeur vide de symbole.
     * Le phoneme aura pour valeur VIDE.
     */
    public Symbol() {
        this.pho=Phoneme.VIDE;
    }

    /** 
     * Construit un symbole a partir d'un phoneme et d'un tableau de longueur indéfinie de lignes.
    */
    public Symbol(Phoneme pho,PosL... pos) {
        this.pho=pho;
        for (PosL p : pos) {
            listLigne.add(new Ligne(p));
        }
    }

    /**
     * Construit un symbole a partir d'un phonème et d'un array list de lignes.
     * @param pho
     * @param listligne
     */
    public Symbol(Phoneme pho,ArrayList<Ligne> listligne) {
        this.pho=pho;
        this.listLigne=listligne;
    }

    /**
     * Construit la fusion de deux symboles à partir d'un symbole intérieur et d'un symbole extérieur.
     * Pas d'information sur le point donc il n'y en a pas.
     * Le phoneme aura pour valeur FUSED.
     * 
     * @param interieur Le symbole intérieur à fusionner.
     * @param exterieur Le symbole extérieur à fusionner.
     */
    public Symbol (Symbol interieur, Symbol exterieur) {
        this.pho=Phoneme.FUSED;
        this.circle=false;
        for (Ligne l : interieur.listLigne) {
            this.listLigne.add(l);
        }
        for (Ligne l : exterieur.listLigne) {
            this.listLigne.add(l);
        }
    }

    /**
     * Construit la fusion d'un symbole à partir de 2 symboles. ajoute un cercle si circle est true, n'ajoute rien sinon.
     * 
     * @param interieur Le symbole intérieur à fusionner.
     * @param exterieur Le symbole exterieur à fusionner.
     * @param circle true si on doit rajoute un cercle, false sinon.
     */
    public Symbol (Symbol interieur, Symbol exterieur, boolean circle) {
        this(interieur,exterieur);
        this.circle=circle;
    }

    // Méthodes :
    public boolean isVide(){
        return this.pho.equals(Phoneme.VIDE);
    }

    /**
     * Trace le symbole en traçant toutes les lignes stockées dans le tableau listLigne. Redefinition de Jpanel.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ligne l : listLigne) {
            int x1 = l.p1.x;
            int y1 = l.p1.y;
            int x2 = l.p2.x;
            int y2 = l.p2.y;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * Affiche la réponse au bout d'un certain temps grace à un timer appelé par la classe réponse.
     * 
     * @param time La durée du timer en secondes.
     */
    public void afficheReponse(int time) {
    Timer timer=new Timer();
        timer.schedule(new Reponse(pho), time*1000);
    }

    /**
     * Demande un phoneme en string à l'utilisateur. Si le phonème entré est conforme, il est testé avec le
     * phonème du symbole et affiche à l'utilisateur
     * @throws IllegalArgumentException
     */
    public void testTrue() throws IllegalArgumentException {
        Scanner sc = new  Scanner(System.in);
        boolean goodInput=false;
        while(!goodInput) {
            try {
                String inputUser = sc.next();
                if (Phoneme.valueOf(inputUser).equals(this.pho)) {
                    System.out.println("Oui bravo : ");
                    afficheReponse(0);
                    goodInput=true;
                }
                else {
                    System.out.println("Non, la bonne réponse est : ");
                    afficheReponse(0);
                }
                goodInput=true;
            } catch (Exception IllegalArgumentException) {
                System.out.println("phoneme invalide");
            }
        }
        sc.close();
   }


    
}

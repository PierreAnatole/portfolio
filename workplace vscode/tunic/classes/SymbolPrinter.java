package tunic.classes;

import javax.swing.JPanel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe s'occupant de la gestion de l'affichage de plusieurs symboles.
 */
public class SymbolPrinter extends JPanel{
    public ArrayList<Symbol> symbols = new ArrayList<Symbol>(); // Liste des symboles
    private Symbol[] temp = new Symbol[2]; // temp[0] contient le symbole intérieur et temp[1] le symbole exterieur.
    public final static int shift = 100; // La largeur d'un signe, donc le décalage entre chaque signe.
    private SymbolRepository SR = new SymbolRepository(); // Base de donnée des symboles.

    /**
     * Crée une ligne de symboles à partir d'un array de symboles ou d'un nombre indéfini de paramètres Symbol.
     * @param symbols Les symboles à afficher.
     */
    public SymbolPrinter(Symbol... symbols){
        for (Symbol symbol : symbols) {
            this.symbols.add(symbol);
        }
    }

    /**
     * Crée une ligne de n symboles à partir de tous les symboles disponibles.
     * @param n Le nombre de symboles à afficher.
     */
    public SymbolPrinter(int n) {
        for (int i = 0; i < n; i++) {
            this.symbols.add(SR.randSymbol());
        }
    }

    /**
     * Crée une ligne de symboles à partir d'un array de phonèmes ou d'un nombre indéfini de paramètres phonème.
     * @param symbols Les phonèmes correspondants aux symboles à afficher.
     */
    public SymbolPrinter(Phoneme... pho) {
        phoArrAddList(pho);
    }

    /**
     * Méthode principale de création d'une liste de symboles. symbols doit être une chaine de caractère contenant des phonèmes,
     * chacun séparés par un espace. Pour créer un symbole vide, utilise le phonème VIDE.
     * @param symbols
     */
    public SymbolPrinter(String symbols) {
        phoArrAddList(String2PhoArr(symbols));
    }

    /**
     * Formate une chaine de caracère en un array de phonèmes de même taille.
     * @param s La chaine de caractère à formater.
     * @return L'array de phonèmes correspondant.
     */
    private Phoneme[] String2PhoArr(String s) {
        String[] strings = s.split(" ");
        Phoneme[] phonemes = new Phoneme[strings.length];
        for (int i = 0; i < strings.length; i++) {
                phonemes[i]=Phoneme.valueOf(strings[i]);
        }
        return phonemes;
    }
    
    /**
     * pour chaque phonème passé en paramètre, décide si :
     * on ajoute le symbole à la liste de symboles (si il n'y a plus de place pour l'afficher),
     * si on fusionne le symbole avec le précédent (si on ajoute un symbole de type différent que le précédent),
     * si on rajoute le point en dessous du symbole(si on rajoute spécifiquement un symbole intérieur après un symbole exterieur).
     * @param pho
     */
    private void phoArrAddList(Phoneme... pho) {
        resetTemp(); // reset mémoire tampon
        for (Phoneme p : pho) {
            Symbol s = SR.getSymbolFromPhoneme(p); // Phonème a traiter en cours.
            if(s.pho.equals(Phoneme.VIDE)) { // Si le phonème est vide (espace), on ajoute execute le tampon et on ajoute à la liste des symboles à afficher un phonème vide et on termine l'itération en cours.
                pushTemp(false);
                symbols.add(new Symbol());
                continue;
            }
            

            if (s instanceof Interieur) {
                if (!(intNull())) { // si on tente d'ajouter un symbole intérieur et qu'il y en a déja un en mémoire :
                    pushTemp(false); // on vide la mémoire
                    temp[0]=s; // on ajoute le nouveau symbole intérieur à la mémoire tampon.
                } else { // sinon si on a une place pour ajouter un symbole intérieur :
                    temp[0]=s; // on l'ajoute à la mémoire tampon.
                    if(!(extNull())) { // si il n'y a pas de place à l'exterieur :
                        pushTemp(true); // on execute la mémoire tampon. Comme l'intérieur est déclaré après l'exterieur, on ajoute un point.
                    }
                }

            } else if (s instanceof Exterieur){ 
                if (!extNull()) { // si on tente d'ajouter un symbole exterieur et qu'il y en a déja un en mémoire :
                    pushTemp(false); // on vide la mémoire
                    temp[1]=s; // on ajoute le nouveau symbole exterieur à la mémoire tampon.
                } else { // sinon si on a une place pour ajouter un symbole exterieur :
                    temp[1]=s; // on l'ajoute à la mémoire tampon.
                    if(!(intNull())) {  // si il n'y a pas de place à l'interieur :
                        pushTemp(false); // on execute la mémoire tampon. Comme l'intérieur est déclaré avant l'exterieur, on n'ajoute pas de point.
                    }
                }
            }
        }

        if (!intNull() || !extNull()) { // Si il y a encore des informations en mémoire tampon on exécute la mémoire tampon.
            pushTemp(false);
        }
    }

    
    /**
     * Fonction auxiliaire permettant de vider le tampon dans la liste de symbole. ajoute un symbole intérieur, extérieur ou fusionné
     * en fonction de l'état de remplissage de la mémoire.
     * Dans le cas d'un symbole fusionné, ajoute un point au symbole si besoin.
     * 
     * @param addCircle true si on doit ajouter un point au symbole fusionné, false sinon.
     */
    private void pushTemp(boolean addCircle) {
        if (!intNull() && !extNull()){
            symbols.add(new Symbol(temp[0],temp[1],addCircle));
        } else if (extNull() && (!intNull())) {
            symbols.add(temp[0]);
        } else if (intNull() && (!extNull())) {
            symbols.add(temp[1]);
        }
        resetTemp();
    }

    /**
     * Fonction auxiliaire qui renseigne si la mémoire tampon ne contient un symbole intérieur.
     * 
     * @return true si la mémoire ne contient pas de symbole intérieur, false si la mémoire contientun symbole intérieur.
     */
    private boolean intNull() {
        return(temp[0].isVide());
    }

    /**
     * Fonction auxiliaire qui renseigne si la mémoire tampon ne contient un symbole extérieur.
     * 
     * @return true si la mémoire ne contient pas de symbole extérieur, false si la mémoire contientun symbole extérieur.
     */
    private boolean extNull() {
        return(temp[1].isVide());
    }

    /**
     * Reset la mémoire tampon avec des symboles vides.
     */
    private void resetTemp() {
        temp[0]=new Symbol();
        temp[1]=new Symbol();
    }

    /**
     * Trace toutes les lignes stockées dans le tableau de chaque symbole, le tout pour chaque symbole.
     * chaque symbole est décale de shift pixels. Une ligne horizontale est ajoutée pour chaque symbole, sauf pour le symbole vide.
     */
    public void paint(Graphics g) {
        super.paint(g);
        
        int index = 0;
        for (Symbol symbol : symbols) {
            for (Ligne l : symbol.listLigne) {
                int x1 = l.p1.x+index*shift;
                int y1 = l.p1.y;
                int x2 = l.p2.x+index*shift;
                int y2 = l.p2.y;
                g.drawLine(x1, y1, x2, y2);
            }
            if (symbol.circle) {
                g.drawOval(Point.xCircle+index*shift, Point.yCircle, Point.rayonCircle, Point.rayonCircle);
            }
            if (!(symbol.pho.equals(Phoneme.VIDE))) {
                g.drawLine(Point.x1Horiz+index*shift, Point.yHoriz, Point.x2Horiz+index*shift, Point.yHoriz);
            }
            index++;
        }
    }
}

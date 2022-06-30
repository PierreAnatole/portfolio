package tunic.classes;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.TimerTask;

/**
 * Classe qui hérite de timerTask. 
 * Force une redéfinition de la methode run, qui correspond aux instructions à realiser à la fin du timer.
 */
public class Reponse extends TimerTask{
    Phoneme pho;
    private static Dictionary<Phoneme, String> messages = new Hashtable<Phoneme,String>();
    public String message;

    /**
     * Constructeur de reponse. Il definit le phonème en paramètre.
     * @param pho Le phonème utilisé pour instancier l'objet.
     */
    public Reponse (Phoneme pho) {
        this.pho=pho;
        if (Reponse.messages.isEmpty()) {
            initMessages();
        }
        
    }
    
    /**
     * Execute la lecture du message correspondant au phonème de la classe.
     */
    public void run() {
        System.out.println(Reponse.messages.get(this.pho));
    }

    /**
     * Initialise les messages corres
     */
    private void initMessages () {
        Reponse.messages.put(Phoneme.AR, "AR : arm");
        Reponse.messages.put(Phoneme.A, "A : glass");
        Reponse.messages.put(Phoneme.AH, "AH : swan");
        Reponse.messages.put(Phoneme.AY, "AY : bay");
        Reponse.messages.put(Phoneme.E, "E : end");
        Reponse.messages.put(Phoneme.EE, "EE : bee");
        Reponse.messages.put(Phoneme.EER, "EER : beer");
        Reponse.messages.put(Phoneme.EH, "EH : the");
        Reponse.messages.put(Phoneme.ERE, "ERE : air");
        Reponse.messages.put(Phoneme.I, "I : bit");
        Reponse.messages.put(Phoneme.IE, "IE : guy");
        Reponse.messages.put(Phoneme.IR, "IR : bird");
        Reponse.messages.put(Phoneme.OH, "OH : toe");
        Reponse.messages.put(Phoneme.OI, "OI : toy");
        Reponse.messages.put(Phoneme.OO, "OO : too");
        Reponse.messages.put(Phoneme.OU, "OU : wolf");
        Reponse.messages.put(Phoneme.OW, "OW : how");
        Reponse.messages.put(Phoneme.ORE, "ORE : your");
        Reponse.messages.put(Phoneme.B, "B : baby");
        Reponse.messages.put(Phoneme.CH, "CH : chat");
        Reponse.messages.put(Phoneme.D, "D : dog");
        Reponse.messages.put(Phoneme.F, "F : fox");
        Reponse.messages.put(Phoneme.G, "G : gum");
        Reponse.messages.put(Phoneme.H, "H : hop");
        Reponse.messages.put(Phoneme.J, "J : jam");
        Reponse.messages.put(Phoneme.K, "K : cat");
        Reponse.messages.put(Phoneme.L, "L : live");
        Reponse.messages.put(Phoneme.M, "M : man");
        Reponse.messages.put(Phoneme.N, "N : net");
        Reponse.messages.put(Phoneme.NG, "NG : sink");
        Reponse.messages.put(Phoneme.P, "P : poppy");
        Reponse.messages.put(Phoneme.R, "R : rum");
        Reponse.messages.put(Phoneme.S, "S : sit");
        Reponse.messages.put(Phoneme.SH, "SH : shut");
        Reponse.messages.put(Phoneme.T, "T : tunic");
        Reponse.messages.put(Phoneme.TH, "TH : thick");
        Reponse.messages.put(Phoneme.th, "TH : this");
        Reponse.messages.put(Phoneme.V, "V : vine");
        Reponse.messages.put(Phoneme.W, "W : wit");
        Reponse.messages.put(Phoneme.Y, "Y : you");
        Reponse.messages.put(Phoneme.Z, "Z : zit");
        Reponse.messages.put(Phoneme.ZH, "ZH : azure");
    }

}

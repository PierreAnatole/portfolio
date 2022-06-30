package entities;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe contenant les listes de tous les symboles du jeu tunic.
 */
public class SymbolRepository {
    public ArrayList<Symbol> symbs = new ArrayList<>(); // La liste de tous les symboles.
    public ArrayList<Interieur> symbInt = new ArrayList<>(); // La liste de tous les symboles intérieurs.
    public ArrayList<Exterieur> symbExt = new ArrayList<>(); // La liste de tous les symboles extérieurs.

    /**
     * Crée un répértoire contenant tous les symboles et l'initialise avec tous les symboles possibles.
     */
    public SymbolRepository() {
        initExt();
        initInt();
        symbs.addAll(symbExt);
        symbs.addAll(symbInt);
    }

    /**
     * Renvoie un symbole au hasard parmis la liste de tous les symboles disponibles.
     * @return Un symbole.
     */
    public Symbol randSymbol() {
        Random r = new Random();
        return this.symbs.get(r.nextInt(this.symbs.size()));
    }

    /**
     * Renvoie un symbole extérieur au hasard parmis la liste de tous les symboles extérieur disponibles.
     * @return Un symbole extérieur.
     */
    public Exterieur randExt() {
        Random r = new Random();
        return this.symbExt.get(r.nextInt(this.symbExt.size()));
    }
    
    /**
     * Renvoie un symbole intérieur au hasard parmis la liste de tous les symboles intérieur disponibles.
     * @return Un symbole intérieur.
     */
    public Interieur randInt() {
        Random r = new Random();
        return this.symbInt.get(r.nextInt(this.symbInt.size()));
    }

    /**
     * Renvoie la fusion de deux symboles (intérieur + extérieur) au hasard.
     * @return un symbole fusionné au hasard.
     */
    public Symbol randFused() {
        return new Symbol(randInt(),randExt());
    }

    /**
     * Renvoie le symbole correspondant au phoneme passé en paramètre.
     * 
     * @param pho Le phonème à partir duquel trouver un symbole.
     * @return Le symbole correspondant au phonème passé en paramètre.
     */
    public Symbol getSymbolFromPhoneme(Phoneme pho) {
        for (Symbol symbol : this.symbs) {
            if (symbol.pho.equals(pho)) {
                return symbol;
            }
        }
        return new Symbol();
    }

    /**
     * Initialise les symboles extérieurs.
     */
    public void initExt() {
        // 1 lignes
        this.symbExt.add(new Exterieur(Phoneme.AY,PosL.GH));
        this.symbExt.add(new Exterieur(Phoneme.IE,PosL.DH));
        this.symbExt.add(new Exterieur(Phoneme.OI,PosL.GB));
        this.symbExt.add(new Exterieur(Phoneme.OW,PosL.DB));
        // 2 lignes
        this.symbExt.add(new Exterieur(Phoneme.AH,PosL.G,PosL.GH));
        this.symbExt.add(new Exterieur(Phoneme.EH,PosL.GH,PosL.DH));
        this.symbExt.add(new Exterieur(Phoneme.I,PosL.GB,PosL.DB));
        this.symbExt.add(new Exterieur(Phoneme.ERE,PosL.G,PosL.DB));
        this.symbExt.add(new Exterieur(Phoneme.OU,PosL.G,PosL.GB));
        // 3 lignes
        this.symbExt.add(new Exterieur(Phoneme.A,PosL.DH,PosL.GH,PosL.G));
        this.symbExt.add(new Exterieur(Phoneme.E,PosL.G,PosL.GB,PosL.DB));
        this.symbExt.add(new Exterieur(Phoneme.EER,PosL.GH,PosL.G,PosL.DB));
        // 4 lignes
        this.symbExt.add(new Exterieur(Phoneme.AR,PosL.DH,PosL.GH,PosL.DB,PosL.GB));
        this.symbExt.add(new Exterieur(Phoneme.EE,PosL.GH,PosL.G,PosL.GB,PosL.DB));
        this.symbExt.add(new Exterieur(Phoneme.IR,PosL.DH,PosL.G,PosL.GB,PosL.DB));
        this.symbExt.add(new Exterieur(Phoneme.OO,PosL.DH,PosL.GH,PosL.G,PosL.GB));
        this.symbExt.add(new Exterieur(Phoneme.ORE,PosL.GH,PosL.DH,PosL.G,PosL.DB));
        // 5 lignes
        this.symbExt.add(new Exterieur(Phoneme.OH,PosL.GH,PosL.DH,PosL.G,PosL.GB,PosL.DB));
    }

    public void initInt() {
        // 2 lignes
        this.symbInt.add(new Interieur(Phoneme.M, PosL.db,PosL.gb));
        this.symbInt.add(new Interieur(Phoneme.W, PosL.dh,PosL.gh));
        this.symbInt.add(new Interieur(Phoneme.N, PosL.db,PosL.gb,PosL.gh));
        
        // 3 lignes
        this.symbInt.add(new Interieur(Phoneme.L, PosL.m,PosL.mh,PosL.mb));
        this.symbInt.add(new Interieur(Phoneme.B, PosL.m,PosL.mh,PosL.db));
        this.symbInt.add(new Interieur(Phoneme.CH, PosL.m,PosL.mb,PosL.gh));
        this.symbInt.add(new Interieur(Phoneme.J, PosL.m,PosL.mh,PosL.gb));
        this.symbInt.add(new Interieur(Phoneme.P, PosL.m,PosL.mb,PosL.dh));
        
        
        // 4 lignes (Y)
        this.symbInt.add(new Interieur(Phoneme.D, PosL.m,PosL.mh,PosL.gb,PosL.db));
        this.symbInt.add(new Interieur(Phoneme.T, PosL.m,PosL.mb,PosL.dh,PosL.gh));
        
        // 4 lignes (fourche)
        this.symbInt.add(new Interieur(Phoneme.R, PosL.m,PosL.mb,PosL.mh,PosL.dh));
        this.symbInt.add(new Interieur(Phoneme.H, PosL.m,PosL.mb,PosL.mh,PosL.db));
        this.symbInt.add(new Interieur(Phoneme.Y, PosL.m,PosL.mb,PosL.mh,PosL.gh));
        
        // 4 lignes
        this.symbInt.add(new Interieur(Phoneme.F, PosL.m,PosL.mb,PosL.gb,PosL.dh));
        this.symbInt.add(new Interieur(Phoneme.V, PosL.m,PosL.mh,PosL.gh,PosL.db));
        this.symbInt.add(new Interieur(Phoneme.G, PosL.m,PosL.mb,PosL.db,PosL.dh));
        this.symbInt.add(new Interieur(Phoneme.K, PosL.m,PosL.mh,PosL.dh,PosL.db));
        
        
        // 5 lignes (S et Z)
        this.symbInt.add(new Interieur(Phoneme.S, PosL.m,PosL.mb,PosL.mh,PosL.dh,PosL.gb));
        this.symbInt.add(new Interieur(Phoneme.Z, PosL.m,PosL.mh,PosL.mb,PosL.gh,PosL.db));
        
        // 5 lignes (patte)
        this.symbInt.add(new Interieur(Phoneme.TH, PosL.m,PosL.mb,PosL.dh,PosL.mh,PosL.gh));
        this.symbInt.add(new Interieur(Phoneme.th, PosL.m,PosL.mh,PosL.db,PosL.mb,PosL.gb));
        
        // 6 lignes
        this.symbInt.add(new Interieur(Phoneme.ZH, PosL.m,PosL.gh,PosL.mh,PosL.dh,PosL.db,PosL.gb));
        this.symbInt.add(new Interieur(Phoneme.SH, PosL.m,PosL.gh,PosL.dh,PosL.gb,PosL.mb,PosL.db));
        
        // 7 lignes
        this.symbInt.add(new Interieur(Phoneme.NG, PosL.m,PosL.gh,PosL.mh,PosL.dh,PosL.gb,PosL.mb,PosL.db));
    };
}

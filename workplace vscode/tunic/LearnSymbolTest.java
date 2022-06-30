package tunic;

import java.awt.Color;
import java.awt.Dimension;

import tunic.classes.GUIHelper;
import tunic.classes.SymbolRepository;
import tunic.classes.Symbol;
import tunic.classes.SymbolPrinter;

public class LearnSymbolTest {
    public static void main(String[] args) {
        SymbolRepository SR = new SymbolRepository();

        // Bibliothèque à choisir :
        Symbol rSymb = SR.randSymbol();
        // Symbol rInt = SR.randInt();
        // Symbol rExt = SR.randExt();

        Symbol toTest = rSymb;
        SymbolPrinter SP = new SymbolPrinter(toTest);
        SP.setBackground(Color.white);
        SP.setPreferredSize(new Dimension(200,200));
        GUIHelper.showOnFrame(SP,"Tunic Learn");

        // Mode de jeu :
        toTest.testTrue();
        // toTest.afficheReponse(3);
    }
}

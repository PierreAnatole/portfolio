package test;

import java.awt.Color;
import java.awt.Dimension;

import entities.GUIHelper;
import entities.SymbolRepository;
import entities.Symbol;
import entities.SymbolPrinter;

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
//      toTest.testTrue();
        toTest.afficheReponse(1);
    }
}

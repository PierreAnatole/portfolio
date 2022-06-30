package test;

import java.awt.Color;
import java.awt.Dimension;

import entities.GUIHelper;
import entities.SymbolPrinter;

public class AfficheMultiTest {
    public static void main(String[] args) {
        SymbolPrinter SP = new SymbolPrinter("th EH VIDE G OH L D I N VIDE P A TH");
        SP.setBackground(Color.white);
        SP.setPreferredSize(new Dimension(100+SP.symbols.size()*100,200));
        GUIHelper.showOnFrame(SP,"Tunic affiche");
    }
}

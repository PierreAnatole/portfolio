package tunic.classes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Methodes statiques d'aide a l'affichage.
 */
public class GUIHelper {
    
    /**
     * Montre un composent.
     * 
     * @param component Le composent à montrer.
     * @param frameName Le nom du composant.
     */
    public static void showOnFrame(JComponent component, String frameName) {
        JFrame frame = new JFrame(frameName);
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frame.addWindowListener(wa);
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);
    }

    

}
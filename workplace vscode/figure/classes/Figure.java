package figure.classes;

/**
 * Classe représentant une figure géometrique en 2 dimensions.
 */
public abstract class Figure implements FigureInterface{
    
    /**
     * Compare la figure avec une autre et renvoie celle qui possède le plus grand périmètre.
     * @param f La figure à comparer avec l'instance en cours.
     * @return La figure possédant le plus grand périmètre.
     */
    public Figure maxPerimetre(Figure f) {
        if (this.calculPerimetre()>=f.calculPerimetre()) {
            return this;
        } 
        else {
            return f;
        }
    }

    /**
     * Compare la figure avec une autre et renvoie celle qui possède la plus grande aire.
     * @param f La figure à comparer avec l'instance en cours.
     * @return La figure possédant la plus grande aire.
     */
    public Figure maxAire(Figure f) {
        if (this.calculAire()>=f.calculAire()) {
            return this;
        } 
        else {
            return f;
        }
    }
}

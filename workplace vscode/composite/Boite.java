package composite;

public class Boite implements Component{
    private String nom;
    Component[] children;
    private int depth;

    public Boite (String nom, Component... components) {
        this.nom=nom;
        this.children= new Component[components.length];
        for (int i=0; i<components.length; i++) {
            this.children[i]=components[i];
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i=0; i<children.length; i++) {
            total+=children[i].getTotalPrice();
        }
        return total;
    }

    @Override
    public void afficheTotalPrice() {
        System.out.println(getTotalPrice());
    }

    public void setChildrenFromArgs(Component... components) {
        this.children= new Component[components.length];
        for (int i=0; i<components.length; i++) {
            this.children[i]=components[i];
        }
    }

    @Override
    public void parcoursArbo() {
        System.out.println(nom);
        int depth=this.depth;
        for (int i=0; i<children.length; i++) {
            this.children[i].setDepth(this.depth+1);
            System.out.print(new String(new char[depth+1]).replace("\0", "--")); // affiche depth+1 fois la chaine "--"
            this.children[i].parcoursArbo();
        }
    }

    public void afficheArbo () {
        this.depth=0;
        parcoursArbo();
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    
}

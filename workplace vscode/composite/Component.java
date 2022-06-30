package composite;

public interface Component {
    public int getTotalPrice();
    public void afficheTotalPrice();
    public void parcoursArbo();
    public void afficheArbo();

    public int getDepth();
    public void setDepth(int depth);
}

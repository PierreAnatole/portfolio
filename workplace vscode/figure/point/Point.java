package figure.point;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }

    /**
     * Affiche les coordonnées du point sous la forme : p = (x, y) .
     */
    public void affiche() {
        System.out.println("p = ("+x+", "+y+")");
    }

    public void translation(double dx, double dy) {
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    
}

package figure.point;

public class Segment {
    private Point p1 ;
    private Point p2;
    private double longueur;

    public Segment (double x1, double y1, double x2, double y2) {
        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        this.p1=p1;
        this.p2=p2;
        updateLongueur();
    }

    public void updateLongueur() {
        double xCoords = Math.abs(this.p1.getX()-this.p2.getX());
        double yCoords = Math.abs(this.p1.getY()-this.p2.getY());
        this.longueur=Math.sqrt(Math.pow(xCoords, 2)+Math.pow(yCoords, 2));
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
        updateLongueur();
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        updateLongueur();
    }

    public double getLongueur() {
        updateLongueur();
        return longueur;
    }


    

}

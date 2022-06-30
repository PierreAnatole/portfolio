package tunic.classes;

/**
 * Un point. On initialise un point avec : 
 * DH, MH, GH pour les 3 points exterieurs haut (droite haut, milieu haut, gauche haut).
 * DB, MB, GB pour les 3 points exterieurs bas (droite bas, milieu bas, gauche bas).
 * h, b pour les 2 points interieurs (haut, bas).
 * 
 * x1..x3 correspondent aux 3 positions x du plan.
 * y1..y6 correspondent aux 6 positions y du plan.
 */
public class Point {

    public static final int x1=30;
    public static final int x2=80;
    public static final int x3=130;

    public static final int y1=10;
    public static final int y2=40;
    public static final int y3=70;
    public static final int y4=110;
    public static final int y5=140;
    public static final int y6=170;

    public static final int xCircle=72;
    public static final int yCircle=175;
    public static final int rayonCircle=16;

    public static final int x1Horiz=x1;
    public static final int x2Horiz=x3;
    public static final int yHoriz=90;
    

    public int x;
    public int y;

    public Point(PosP pos) {
        
        switch (pos) {
            case MH:
                this.x = x2;
                this.y = y1;
                break;
            case DH:
                this.x = x3;
                this.y = y2;
                break;
            case GH:
                this.x = x1;
                this.y = y2;
                break;
            case DB:
                this.x = x3;
                this.y = y5;
                break;
            case GB:
                this.x = x1;
                this.y = y5;
                break;
            case MB:
                this.x = x2;
                this.y = y6;
                break;
            case h:
                this.x = x2;
                this.y = y3;
                break;
            case b:
                this.x = x2;
                this.y = y4;
                break;
        
            default:
                System.out.println("point invalide");
        }
    }
    
}

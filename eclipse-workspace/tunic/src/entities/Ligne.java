package entities;


/**
 * Une ligne constituée de 2 points. On initialise une ligne avec : 
 * 
 * <p>
 * GH,DH,G,GB,DB pour une des 5 lignes exterieures.
 * (gauche haut, droite haut, gauche, gauche bad, droite bas).
 * </p>
 * 
 * <p>
 * dh,mh,gh,db,mb,gb,m pour une des 7 lignes intérieures.
 * (droite haut, milieu haut,gauche haut, droite bas, milieu bas, gauche bas, milieu).
 * </p>
 * 
 */
public class Ligne{
    public Point p1;
    public Point p2;

    public Ligne (PosL pos) {
        switch (pos) {
            case GH:
                this.p1=new Point(PosP.GH);
                this.p2=new Point(PosP.MH);
                break;
            case DH:
                this.p1=new Point(PosP.MH);
                this.p2=new Point(PosP.DH);
                break;
            case G:
                this.p1=new Point(PosP.GB);
                this.p2=new Point(PosP.GH);
                break;
            case GB:
                this.p1=new Point(PosP.MB);
                this.p2=new Point(PosP.GB);
                break;
            case DB:
                this.p1=new Point(PosP.MB);
                this.p2=new Point(PosP.DB);
                break;
            case gh:
                this.p1=new Point(PosP.GH);
                this.p2=new Point(PosP.h);
                break;
            case dh:
                this.p1=new Point(PosP.DH);
                this.p2=new Point(PosP.h);
                break;
            case mh:
                this.p1=new Point(PosP.MH);
                this.p2=new Point(PosP.h);
                break;
            case m:
                this.p1=new Point(PosP.h);
                this.p2=new Point(PosP.b);
                break;
            case db:
                this.p1=new Point(PosP.DB);
                this.p2=new Point(PosP.b);
                break;
            case mb:
                this.p1=new Point(PosP.MB);
                this.p2=new Point(PosP.b);
                break;
            case gb:
                this.p1=new Point(PosP.GB);
                this.p2=new Point(PosP.b);
                break;
            
            default:
                System.out.println("ligne invalide");
        }
    }



}

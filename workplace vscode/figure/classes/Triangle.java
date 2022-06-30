package figure.classes;

public class Triangle extends Polygone{
    public final static int nbCote=3;
    private double coteA;
    private double coteB;
    private double coteC;
    TriangleType typeDuTriangle;

    public Triangle(double coteA, double coteB, double coteC) {
        this.coteA=coteA;
        this.coteB=coteB;
        this.coteC=coteC;
        this.typeDuTriangle=checkTriangleType(coteA,coteB, coteC);
    }

    /**
     * Calcule l'aire du triangle
     */
    @Override
    public double calculAire() {
        Double d = ((coteA+coteB+coteC)/2);
        return Math.sqrt(d*(d-coteA)*(d-coteB)*(d-coteC));
    }

    /**
     * Calcule le périmètre du triangle.
     */
    @Override
    public double calculPerimetre() {
        return coteA+coteB+coteC;
    }

    /**
     * Renvoie le type du triangle en fonction de la longueur de ses 3 côtés entrés en paramètre parmis les types définis dans l'enum TriangleType.
     * Type IMPOSSIBLE : les côtés ne correspondent pas à un triangle.
     * Type EQUILATERAL : les 3 côtés sont égaux.
     * Type RECTANGLE_ISOCELE : le triangle est un triangle rectangle et isocèle.
     * Type RECTANGLE : le triangle possède un angle droit.
     * Type ISOCELE : exactement 2 côtés du triangle sont égaux.
     * Type SCALENE : le 3 côtés sont de longueurs différentes.
     * 
     * @param A Le côté A du triangle.
     * @param B Le côté B du triangle.
     * @param C Le côté C du triangle.
     * @return Le type du triangle.
     */
    public TriangleType checkTriangleType (double A, double B, double C){
        if (!isATriangle(A, B, C)) { // Si le triangle à des dimensions impossibles alors il est de type impossible.
            return TriangleType.IMPOSSIBLE;
        }

        if (isEquilateral(A, B, C)){ // Si les 3 cotés sont égaux le triangle est équilatéral.
            return TriangleType.EQUILATERAL;
        }
        
        if (isRectangle(A, B, C)){ // Si le triangle vérifie le théorème de pythagore alors il est rectangle.
            
            if (isIsocele(A, B, C)) { // Si le triangle rectangle est aussi isocèle, alors il est rectangle et isocèle.
                return TriangleType.RECTANGLE_ISOCELE;
            }
            else { // Sinon le triangle est seulement rectangle (ou rectangle scalene).
                return TriangleType.RECTANGLE;
            }
        }

        if(isIsocele(A, B, C)) { // Si le triangle a deux côtés egaux alors il est isocèle.
            return TriangleType.ISOCELE;
        }

        return TriangleType.SCALENE; // Si le triangle ne vérifie aucune des conditions alors il est scalene.
    }

    /**
     * Retourne true si les cotés entrés en paramètre correspondent à un triangle.
     * @param A Le côté A du triangle à tester.
     * @param B Le côté B du triangle à tester.
     * @param C Le côté C du triangle à tester.
     * @return true si les cotés entrés en paramètre correspondent à un triangle, false sinon.
     */
    public boolean isATriangle(double A, double B, double C) {
        boolean b = ((B+C>A)&&(A+C>B)&&(A+B>C)) ? true : false;
        return b;
    }

    /**
     * Retourne true si les cotés entrés en paramètre vérifient le théorème de pythagore et donc correspondent à un triangle rectangle.
     * @param A Le côté A du triangle à tester.
     * @param B Le côté B du triangle à tester.
     * @param C Le côté C du triangle à tester.
     * @return true si les cotés entrés en paramètre correspondent à un triangle rectangle, false sinon.

     */
    public boolean isRectangle (double A, double B, double C) {
        if ((Math.pow(A, 2)+Math.pow(B, 2) == Math.pow(C, 2)) || (Math.pow(A, 2)+Math.pow(C, 2) == Math.pow(B, 2)) || (Math.pow(B, 2)+Math.pow(C, 2) == Math.pow(A, 2))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Retourne true si les cotés entrés en paramètre correspondent à un triangle équilateral.
     * @param A Le côté A du triangle à tester.
     * @param B Le côté B du triangle à tester.
     * @param C Le côté C du triangle à tester.
     * @return true si les cotés entrés en paramètre correspondent à un triangle équilateral, false sinon.

     */
    public boolean isEquilateral(double A, double B, double C) {
        boolean b = ((A==B)&&(B==C)&&(C==A)) ? true : false;
        return b;
    }

    /**
     * Retourne true si les cotés entrés en paramètre correspondent à un triangle isocèle. Ici on considère qu'un triangle équilatéral n'est pas isocèle.
     * @param A Le côté A du triangle à tester.
     * @param B Le côté B du triangle à tester.
     * @param C Le côté C du triangle à tester.
     * @return true si les cotés entrés en paramètre correspondent à un triangle isocèle, false sinon.

     */
    public boolean isIsocele(double A, double B, double C) {
        if (isEquilateral(A, B, C)) {
            return false;
        }
        if ((A==B)||(B==C)||(C==A)) {
            return true;
        }
        else {
            return false;
        }
    }

    public TriangleType getTypeDuTriangle() {
        return typeDuTriangle;
    }
    
}

package figure;

import figure.classes.Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle t0 = new Triangle(2, 3, 8); // impossible
        Triangle t1 = new Triangle(6,6,6); // equilateral
        Triangle t2 = new Triangle(3,4,5); // rectangle
        Triangle t3 = new Triangle(8,9,10); // scalene
        Triangle t4 = new Triangle(8,8,5); // isocèle
        Triangle t5 = new Triangle(8.48528137423860,6.00000000000002,6.00000000000002); // rectangle isocèle

        

        System.out.println("t0 : "+t0.getTypeDuTriangle());
        System.out.println("t1 : "+t1.getTypeDuTriangle());
        System.out.println("t2 : "+t2.getTypeDuTriangle());
        System.out.println("t3 : "+t3.getTypeDuTriangle());
        System.out.println("t4 : "+t4.getTypeDuTriangle());
        System.out.println("t5 : "+t5.getTypeDuTriangle());
        
    }
}

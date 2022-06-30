package singleton;

import java.lang.Comparable;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("s1 est égal à s2 : "+s1.equals(s2));
        System.out.println("s1 et s2 ont la même référence : "+(s1==s2));

    }
}

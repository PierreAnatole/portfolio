package animal.classes;

import java.util.ArrayList;
import java.util.List;

public class Vache extends Animal{

    private static List<Vache> tabVache = new ArrayList<Vache>();

    public Vache(int age) {
        super(age);
        addToTab();
    }

    public void addToTab(){
        tabVache.add(this);
    }

    public void removeToTab() {
        tabVache.remove(this);
    }

    @Override
    public String toString() {
        return "Vache";
    }

    @Override
    public void crier() {
        System.out.println("Meuh");
    }

    public static List<Vache> getTabVache() {
        return tabVache;
    }

    

}

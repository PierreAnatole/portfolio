package factory_method;

import factory_method.transports.Plane;
import factory_method.utils.Item;

public class Main {
    public static void main(String[] args) {
        //création des 3 factory
        PlaneLogistics pl = new PlaneLogistics();
        RoadLogistics rl = new RoadLogistics();
        SeaLogistics sl = new SeaLogistics();

        //création d'une instance de chaque objet grace aux factories, dans une liste de transports.
        Transport[] transports = new Transport[3];
        transports[0]= pl.createTransport();
        transports[1]= rl.createTransport();
        transports[2]= sl.createTransport();

        //création de 3 objets à livrer
        Item[] items = new Item[3];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item("Item n° "+i);
        }

        //chaque élément de type transport implémente la méthode deliver.
        for (int i = 0; i < transports.length; i++) {
            transports[i].deliver(items[i]);
        }


        
    }
}

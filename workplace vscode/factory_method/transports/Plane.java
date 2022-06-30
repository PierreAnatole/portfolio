package factory_method.transports;

import factory_method.Transport;
import factory_method.utils.Item;

public class Plane implements Transport{
    
    @Override
    public void deliver(Item i) {
        i.setDelivered(true);
        System.out.println(i.getName()+" livré en avion");
    }
}

package factory_method;

import factory_method.transports.Truck;

public class RoadLogistics extends Logistics{

    
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

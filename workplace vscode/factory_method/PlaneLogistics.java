package factory_method;

import factory_method.transports.Plane;

public class PlaneLogistics extends Logistics{

    @Override
    public Transport createTransport() {
        return new Plane();
    }
    
}

package factory_method;

import factory_method.transports.Boat;

public class SeaLogistics extends Logistics{

    @Override
    public Transport createTransport() {
        return new Boat();
    }
}

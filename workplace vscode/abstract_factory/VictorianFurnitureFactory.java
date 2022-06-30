package abstract_factory;

import abstract_factory.abstract_furnitures.*;
import abstract_factory.abstract_furnitures.furnitures.*;

public class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Couch createCouch() {
        return new VictorianCouch();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
    
}

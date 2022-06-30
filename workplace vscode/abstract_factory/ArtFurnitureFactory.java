package abstract_factory;

import abstract_factory.abstract_furnitures.*;
import abstract_factory.abstract_furnitures.furnitures.*;

public class ArtFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ArtChair();
    }

    @Override
    public Couch createCouch() {
        return new ArtCouch();
    }

    @Override
    public Table createTable() {
        return new ArtTable();
    }
    
}

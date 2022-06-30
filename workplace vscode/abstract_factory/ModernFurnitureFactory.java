package abstract_factory;

import abstract_factory.abstract_furnitures.*;
import abstract_factory.abstract_furnitures.furnitures.*;

public class ModernFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Couch createCouch() {
        return new ModernCouch();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
    
}

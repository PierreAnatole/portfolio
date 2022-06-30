package abstract_factory;

import abstract_factory.abstract_furnitures.*;

public interface FurnitureFactory {
    public Chair createChair();
    public Couch createCouch();
    public Table createTable();
}

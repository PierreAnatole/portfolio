package factory_method.utils;

import java.lang.reflect.Constructor;

public class Item {
    private boolean isDelivered;
    private String name;

    public Item(String name) {
        this.name=name;
        this.isDelivered=false;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }


    //GETTERS SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}

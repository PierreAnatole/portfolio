package prototype;

public abstract class Shape {
    public double x;
    public double y;
    private String color;

    public Shape(){

    };

    // Le constructeur du prototype. Un nouvel objet est
    // initialisé avec les valeurs de l’objet existant.
    public Shape(Shape source) {
        this();
        this.x=source.x;
        this.y=source.y;
        this.color=source.color;
    }

    public abstract Shape clone();
}

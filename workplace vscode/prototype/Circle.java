package prototype;

public class Circle extends Shape{
    private double radius;

    public Circle(Circle source) {
        super(source);
        this.radius=source.radius;
    }

    public Circle() {
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    
}

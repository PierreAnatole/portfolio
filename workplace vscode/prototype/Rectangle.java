package prototype;

public class Rectangle extends Shape {
    private double width;
    private double heigth;

    public Rectangle(Rectangle source) {
        super(source);
        this.width=source.width;
        this.heigth=source.heigth;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
    
}

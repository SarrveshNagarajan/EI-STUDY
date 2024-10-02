interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Legacy rectangle class
class LegacyRectangle {
    public void drawRectangle() {
        System.out.println("Drawing Rectangle with legacy system");
    }
}

// Adapter to make LegacyRectangle compatible with Shape
class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw() {
        legacyRectangle.drawRectangle();
    }
}

public class ShapeDrawingDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new RectangleAdapter(new LegacyRectangle());

        circle.draw();
        rectangle.draw();
    }
}
package designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {
    
    public static void main(String[] args) {
        // Creating leaf graphics
        Graphic ellipse1 = new Ellipse();
        Graphic rectangle = new Rectangle();
        Graphic circle = new Circle();

        // Creating composite graphic and adding leaf graphics
        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(ellipse1);
        compositeGraphic.add(rectangle);
        compositeGraphic.add(circle);

        // Drawing composite graphic (which draws all leaf graphics)
        compositeGraphic.draw();
    }
}

// Component interface
interface Graphic {
    void draw();
}

// Leaf class
class Ellipse implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing an ellipse");
    }
}

class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Composite class
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    void add(Graphic graphic) {
        graphics.add(graphic);
    }

    void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

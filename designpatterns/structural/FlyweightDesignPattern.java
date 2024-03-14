package designpatterns.structural;


import java.util.HashMap;

public class FlyweightDesignPattern {
    public static void main(String[] args) {
        // Create and display trees
        TreeType oak = TreeFactory.getTreeType("Oak", "Green", "Smooth");
        oak.display(100, 100);

        TreeType pine = TreeFactory.getTreeType("Pine", "Green", "Rough");
        pine.display(200, 200);

        TreeType maple = TreeFactory.getTreeType("Maple", "Red", "Smooth");
        maple.display(300, 300);

        // Reusing existing tree types
        TreeType oak2 = TreeFactory.getTreeType("Oak", "Green", "Smooth");
        oak2.display(400, 400);
    }
}

// Flyweight interface
interface Tree {
    void display(int x, int y);
}

// Concrete flyweight class
class TreeType implements Tree {
    private final String name;
    private final String color;
    private final String texture;

    TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("TreeType: " + name + ", Color: " + color + ", Texture: " + texture + ", Location: (" + x + ", " + y + ")");
    }
}

// Flyweight factory
class TreeFactory {
    private static final HashMap<String, TreeType> treeTypes = new HashMap<>();

    static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        // If object if already created then return same object
        TreeType treeType = treeTypes.get(key);
        if (treeType == null) {
            treeType = new TreeType(name, color, texture);
            treeTypes.put(key, treeType);
        }
        return treeType;
    }
}

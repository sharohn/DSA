package designpatterns.creational;
import java.util.HashMap;
import java.util.Map;

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        // Create a prototype instance
        ConcretePrototype prototype = new ConcretePrototype("Initial Property");

        // Register the prototype in the registry (optional)
        PrototypeRegistry.registerPrototype("prototypeKey", prototype);

        // Clone the prototype to create a new instance
        ConcretePrototype clone = (ConcretePrototype) prototype.clone();
        clone.setProperty("Modified Property");

        // Output properties of prototype and clone
        System.out.println("Prototype Property: " + prototype.getProperty());
        System.out.println("Clone Property: " + clone.getProperty());
    }
}

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype class
class ConcretePrototype implements Prototype {
    private String property;

    public ConcretePrototype(String property) {
        this.property = property;
    }

    @Override
    public Prototype clone() {
        // Create a new instance and copy the property
        return new ConcretePrototype(this.property);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}

// Prototype registry (optional)
class PrototypeRegistry {
    private static final Map<String, Prototype> prototypes = new HashMap<>();

    public static void registerPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public static Prototype getPrototype(String key) {
        return prototypes.get(key).clone();
    }
}

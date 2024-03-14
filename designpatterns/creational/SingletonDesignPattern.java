package designpatterns.creational;

/**
 * SingletonDesignPattern
 */
public class SingletonDesignPattern {
    // Private static instance variable
    private static SingletonDesignPattern instance;

    // Private constructor to prevent instantiation from outside
    private SingletonDesignPattern() {
        // Initialization code
    }

    // Public static method to get the instance
    public static SingletonDesignPattern getInstance() {
        // Lazy initialization: create instance only if it doesn't exist
        if (instance == null) {
            instance = new SingletonDesignPattern();
        }
        return instance;
    }

    
}

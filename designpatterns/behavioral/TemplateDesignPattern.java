package designpatterns.behavioral;

public class TemplateDesignPattern {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        System.out.println("Making tea...");
        tea.prepareBeverage();

        System.out.println();

        Beverage coffee = new Coffee();
        System.out.println("Making coffee...");
        coffee.prepareBeverage();
    }
}

// Abstract Class
abstract class Beverage {
    // Template method
    final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Abstract methods to be implemented by subclasses
    abstract void brew();
    abstract void addCondiments();

    // Concrete methods
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

// Concrete Class - Tea
class Tea extends Beverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete Class - Coffee
class Coffee extends Beverage {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
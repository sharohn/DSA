package designpatterns.structural;

public class DecoratorDesignPatter {
    public static void main(String[] args) {
        // Order a simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("Simple Coffee: " + coffee.getDescription() + ", Cost: $" + coffee.getCost());

        // Add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println("Coffee with Milk: " + coffee.getDescription() + ", Cost: $" + coffee.getCost());

        // Add whipped cream to the coffee
        coffee = new WhippedCreamDecorator(coffee);
        System.out.println("Coffee with Whipped Cream: " + coffee.getDescription() + ", Cost: $" + coffee.getCost());
    }
}

// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 1.0;
    }
}

// Decorator class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Milk costs extra
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    WhippedCreamDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with whipped cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75; // Whipped cream costs extra
    }
}
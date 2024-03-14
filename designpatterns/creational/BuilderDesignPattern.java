package designpatterns.creational;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        PizzaMaker pizzaMaker = new PizzaMaker();

        // Build Margherita pizza
        pizzaMaker.setPizzaBuilder(new MargheritaPizzaBuilder());
        pizzaMaker.constructPizza();
        Pizza margheritaPizza = pizzaMaker.getPizza();
        System.out.println("Margherita Pizza: " + margheritaPizza.getDescription());

        // Build Veggie pizza
        pizzaMaker.setPizzaBuilder(new VeggiePizzaBuilder());
        pizzaMaker.constructPizza();
        Pizza veggiePizza = pizzaMaker.getPizza();
        System.out.println("Veggie Pizza: " + veggiePizza.getDescription());
    }
}



// Product class
class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getDescription() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce, and " + topping + " topping.";
    }
}

// Builder interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}

// Concrete builder classes
class MargheritaPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public MargheritaPizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("thin crust");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("tomato");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("mozzarella cheese");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

class VeggiePizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public VeggiePizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("whole wheat");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("pesto");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("mixed vegetables");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Director class
class PizzaMaker {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

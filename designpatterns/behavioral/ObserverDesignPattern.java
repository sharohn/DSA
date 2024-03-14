package designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Create displays and register them as observers
        Display display1 = new Display("Mobile");
        Display display2 = new Display("Laptop");
        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Update temperature and notify observers
        weatherStation.setTemperature(25);

        // Remove display1
        weatherStation.removeObserver(display1);

        // Update temperature again
        weatherStation.setTemperature(30);
    }
}

// Subject
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private int temperature;
    private List<Observer> observers = new ArrayList<>();

    void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer
interface Observer {
    void update(int temperature);
}

// Concrete Observer
class Display implements Observer {
    private final String name;

    Display(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " Display: Temperature is " + temperature);
    }
}
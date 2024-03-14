package designpatterns.structural;

public class FacadeDesignPattern {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // Watch a movie
        homeTheater.watchMovie("Inception");

        // End the movie
        homeTheater.endMovie();
    }
}


// Subsystem classes/interfaces
class Player {
    void turnOn() {
        System.out.println("Player turned on");
    }

    void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    void turnOff() {
        System.out.println("Player turned off");
    }
}

class SoundSystem {
    void turnOn() {
        System.out.println("Sound system turned on");
    }

    void setVolume(int volume) {
        System.out.println("Setting volume to: " + volume);
    }

    void turnOff() {
        System.out.println("Sound system turned off");
    }
}

class Projector {
    void turnOn() {
        System.out.println("Projector turned on");
    }

    void setInput(String input) {
        System.out.println("Setting input to: " + input);
    }

    void turnOff() {
        System.out.println("Projector turned off");
    }
}

// Facade class
class HomeTheaterFacade {
    private Player player;
    private SoundSystem soundSystem;
    private Projector projector;

    HomeTheaterFacade() {
        player = new Player();
        soundSystem = new SoundSystem();
        projector = new Projector();
    }

    void watchMovie(String movie) {
        player.turnOn();
        soundSystem.turnOn();
        projector.turnOn();
        projector.setInput("Player");
        soundSystem.setVolume(8);
        player.playMovie(movie);
    }

    void endMovie() {
        player.turnOff();
        soundSystem.turnOff();
        projector.turnOff();
    }
}

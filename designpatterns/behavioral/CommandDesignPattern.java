package designpatterns.behavioral;

public class CommandDesignPattern {
    public static void main(String[] args) {
        // Receiver objects
        ElectronicDevice tv = new ElectronicDevice("Television");
        ElectronicDevice stereo = new ElectronicDevice("Stereo System");

        // Concrete command objects
        Command turnOnTV = new TurnOnCommand(tv);
        Command turnOffTV = new TurnOffCommand(tv);
        Command turnOnStereo = new TurnOnCommand(stereo);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Associate commands with invoker
        remote.setCommand(turnOnTV);
        remote.pressButton(); // Turns on the TV
        remote.setCommand(turnOffTV);
        remote.pressButton();

        remote.setCommand(turnOnStereo);
        remote.pressButton(); // Turns on the stereo system
    }
}

// Command interface
interface Command {
    void execute();
}

// Concrete Command
class TurnOnCommand implements Command {
    private final ElectronicDevice device;

    TurnOnCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements Command {
    private final ElectronicDevice device;

    TurnOffCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

// Receiver
class ElectronicDevice {
    private final String name;

    ElectronicDevice(String name) {
        this.name = name;
    }

    void turnOn() {
        System.out.println(name + " is turned on.");
    }

    void turnOff() {
        System.out.println(name + " is turned off.");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}
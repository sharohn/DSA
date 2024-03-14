package designpatterns.structural;

public class BridgeDesignPattern {
    public static void main(String[] args) {
        // Creating a TV and a DVD player
        Device tv = new TV();
        Device dvdPlayer = new DVDPlayer();

        // Using basic remote controls for the TV and DVD player
        RemoteControl tvRemote = new BasicRemoteControl(tv);
        RemoteControl dvdRemote = new BasicRemoteControl(dvdPlayer);

        // Powering on/off the TV and DVD player using the respective remotes
        tvRemote.powerOn();
        dvdRemote.powerOn();
        tvRemote.powerOff();
        dvdRemote.powerOff();
    }
}


// Abstraction
abstract class RemoteControl {
    protected Device device;

    RemoteControl(Device device) {
        this.device = device;
    }

    abstract void powerOn();
    abstract void powerOff();
}

// Refined Abstraction
class BasicRemoteControl extends RemoteControl {
    BasicRemoteControl(Device device) {
        super(device);
    }

    @Override
    void powerOn() {
        device.powerOn();
    }

    @Override
    void powerOff() {
        device.powerOff();
    }
}

// Implementor
interface Device {
    void powerOn();
    void powerOff();
}

// Concrete Implementors
class TV implements Device {
    @Override
    public void powerOn() {
        System.out.println("Turning on the TV");
    }

    @Override
    public void powerOff() {
        System.out.println("Turning off the TV");
    }
}

class DVDPlayer implements Device {
    @Override
    public void powerOn() {
        System.out.println("Turning on the DVD player");
    }

    @Override
    public void powerOff() {
        System.out.println("Turning off the DVD player");
    }
}

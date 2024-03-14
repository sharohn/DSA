package designpatterns.behavioral;

public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {
        SupportHandler supportHandler = new Level1SupportHandler();
 
        supportHandler.handleRequest("basic");
        supportHandler.handleRequest("intermediate");
        supportHandler.handleRequest("critical");
        supportHandler.handleRequest("immediate");
    }
}

// Handler interface
interface SupportHandler {
    void handleRequest(String request);
}

// Concrete handler
class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    Level1SupportHandler() {
        nextHandler = new Level2SupportHandler();
    }
 
    @Override
    public void handleRequest(String request) {
        if (request.equals("basic")) {
            System.out.println("Level 1 Support handled the request.");
        } else {
            nextHandler.handleRequest(request);
        }
    }
}
 
class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;
 
    Level2SupportHandler() {
        this.nextHandler = new Level3SupportHandler();
    }
 
    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("intermediate")) {
            System.out.println("Level 2 Support handled the request.");
        } else {
            nextHandler.handleRequest(request);
        }
    }
}
 
class Level3SupportHandler implements SupportHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("critical")) {
            System.out.println("Level 3 Support handled the request.");
        } else {
            System.out.println("Request cannot be handled.");
        }
    }
}

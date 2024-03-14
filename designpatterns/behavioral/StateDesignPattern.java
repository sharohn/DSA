package designpatterns.behavioral;

public class StateDesignPattern {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Initial state: NoMoneyState
        vendingMachine.insertMoney();
        vendingMachine.selectItem(); 
        vendingMachine.dispenseItem();

        // Insert money
        vendingMachine.insertMoney(); 

        // Select item
        vendingMachine.selectItem(); 
        vendingMachine.dispenseItem(); 
    }
}


// Context
class VendingMachine {
    private State state;

    VendingMachine() {
        this.state = new NoMoneyState();
    }

    void setState(State state) {
        this.state = state;
    }

    void insertMoney() {
        state.insertMoney(this);
    }

    void selectItem() {
        state.selectItem(this);
    }

    void dispenseItem() {
        state.dispenseItem(this);
    }
}

// State
interface State {
    void insertMoney(VendingMachine vendingMachine);
    void selectItem(VendingMachine vendingMachine);
    void dispenseItem(VendingMachine vendingMachine);
}

// Concrete State
class NoMoneyState implements State {
    @Override
    public void insertMoney(VendingMachine vendingMachine) {
        System.out.println("Money inserted");
        vendingMachine.setState(new MoneyInsertedState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) {
        System.out.println("Insert money first");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Insert money first");
    }
}

class MoneyInsertedState implements State {
    @Override
    public void insertMoney(VendingMachine vendingMachine) {
        System.out.println("Money already inserted");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) {
        System.out.println("Item selected");
        vendingMachine.setState(new ItemSelectedState());
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Select item first");
    }
}

class ItemSelectedState implements State {
    @Override
    public void insertMoney(VendingMachine vendingMachine) {
        System.out.println("Item already selected");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Item dispensed");
        vendingMachine.setState(new NoMoneyState());
    }
}
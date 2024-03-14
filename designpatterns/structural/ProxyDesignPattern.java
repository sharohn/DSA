package designpatterns.structural;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        // Create a bank account proxy with initial balance and password
        BankAccount account = new BankAccountProxy(1000, "password123");

        // Perform operations on the bank account proxy
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Current Balance: $" + account.getBalance());

        // Attempting unauthorized access
        BankAccount unauthorizedAccountAccess = new BankAccountProxy(2000, "wrongpassword");
        unauthorizedAccountAccess.withdraw(100);
    }
}


// Subject interface
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Real subject class
class RealBankAccount implements BankAccount {
    private double balance;

    RealBankAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Proxy class
class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String password;

    BankAccountProxy(double initialBalance, String password) {
        this.realBankAccount = new RealBankAccount(initialBalance);
        this.password = password;
    }

    private boolean authenticate(String inputPassword) {
        return inputPassword.equals(password);
    }

    @Override
    public void deposit(double amount) {
        realBankAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (authenticate(password)) {
            realBankAccount.withdraw(amount);
        } else {
            System.out.println("Authentication failed. Access denied.");
        }
    }

    @Override
    public double getBalance() {
        if (authenticate(password)) {
            return realBankAccount.getBalance();
        } else {
            System.out.println("Authentication failed. Access denied.");
            return 0.0;
        }
    }
}
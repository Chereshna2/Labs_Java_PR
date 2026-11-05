package org.example;

public class InsufficientFundsException extends Exception {
    private final double requested;
    private final double balance;

    public InsufficientFundsException(String message, double requested, double balance) {
        super(message);
        this.requested = requested;
        this.balance = balance;
    }

    public double getRequested() { return requested; }
    public double getBalance() { return balance; }
}

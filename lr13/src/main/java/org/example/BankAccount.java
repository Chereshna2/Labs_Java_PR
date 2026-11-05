package org.example;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    // Конструктор вызывает сеттеры для проверки данных
    public BankAccount(String accountNumber, String owner, double initialBalance)
            throws InvalidAmountException, IllegalArgumentException {
        setAccountNumber(accountNumber);
        setOwner(owner);
        setBalance(initialBalance);
    }

    // --- СЕТТЕРЫ С ПРОВЕРКАМИ ---

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счета не может быть пустым");
        }
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым");
        }
        this.owner = owner;
    }

    public void setBalance(double balance) throws InvalidAmountException {
        if (balance < 0) {
            throw new InvalidAmountException("Баланс не может быть отрицательным");
        }
        this.balance = balance;
    }

    // --- ГЕТТЕРЫ ---

    public String getAccountNumber() { return accountNumber; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    // --- БИЗНЕС-МЕТОДЫ ---

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма пополнения должна быть больше нуля");
        }
        setBalance(this.balance + amount); // используем сеттер для изменения
        System.out.println("Успешно пополнено на " + amount + ". Новый баланс: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма снятия должна быть больше нуля");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Недостаточно средств на счете " + accountNumber,
                    amount, balance
            );
        }
        setBalance(this.balance - amount); // используем сеттер для изменения
        System.out.println("Успешно снято " + amount + ". Новый баланс: " + balance);
    }

    public void transfer(BankAccount target, double amount)
            throws InsufficientFundsException, InvalidAmountException, AccountNotFoundException {

        if (target == null) {
            throw new AccountNotFoundException("Целевой счет не найден");
        }
        System.out.println("Попытка перевода " + amount + " на счет " + target.getAccountNumber());

        this.withdraw(amount);
        target.deposit(amount);

        System.out.println("Перевод завершен успешно!");
    }

    @Override
    public String toString() {
        return "Счет: " + accountNumber + " | Владелец: " + owner + " | Баланс: " + balance;
    }
}
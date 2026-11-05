package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в банковскую систему!");

        try {
            System.out.println("\nСоздание счетов...");
            BankAccount acc1 = new BankAccount("ACC-001", "Иван", 1000);
            BankAccount acc2 = new BankAccount("ACC-002", "Мария", 500);
            BankAccount acc3 = new BankAccount("ACC-003", "Петр",-185);

            System.out.println("Счета созданы:");
            System.out.println(acc1);
            System.out.println(acc2);
            System.out.println(acc3);

            System.out.println("\n--- Операции ---");
            acc1.deposit(500);
            acc2.withdraw(200);
            acc1.transfer(acc3, 300);

            System.out.println("\n--- Попытка снять больше, чем есть ---");
            try {
                acc2.withdraw(10000);
            } catch (InsufficientFundsException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("   Запрошено: " + e.getRequested() + " | Доступно: " + e.getBalance());
            }

            System.out.println("\n--- Попытка перевода на несуществующий счет ---");
            try {
                acc1.transfer(null, 100);
            } catch (AccountNotFoundException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.println("\n--- Попытка пополнить на отрицательную сумму ---");
            try {
                acc1.deposit(-50);
            } catch (InvalidAmountException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        } catch (InvalidAmountException e) {
            System.out.println("Ошибка создания счета или операции: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Недостаточно средств: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("Счет не найден: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: вы ввели не число.");
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nПрограмма завершена. Все ресурсы освобождены.");
        }
    }
}
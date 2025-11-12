/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuldem1;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Клас Рахунок
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостатньо коштів!");
        }
    }
}

// Клас Клієнт
class Customer {
    private String firstName;
    private String lastName;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

// Клас Банк
class Bank {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

// Головний клас CLI
public class CLIdemo {

    private static Bank bank = new Bank();

    public static void main(String[] args) {
        initializeBank();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вітаємо у банківському CLI!");
        System.out.println("Введіть 'help' щоб переглянути доступні команди.");

        while (true) {
            System.out.print("\nbank> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("e")) {
                System.out.println("До побачення!");
                break;
            } else if (input.equalsIgnoreCase("help") || input.equalsIgnoreCase("h")) {
                printHelp();
            } else if (input.equalsIgnoreCase("customers") || input.equalsIgnoreCase("cus")) {
                listCustomers();
            } else if (input.startsWith("select")) {
                selectCustomer(input);
            } else if (input.equalsIgnoreCase("report")) {
                printReport();
            } else {
                System.out.println("Невідома команда. Напишіть 'help' для списку команд.");
            }
        }

        scanner.close();
    }

    // Ініціалізація даних (імітація завантаження з файлу)
    private static void initializeBank() {
        Customer c1 = new Customer("Іван", "Іваненко");
        c1.addAccount(new Account(1200.50));
        c1.addAccount(new Account(5000.00));

        Customer c2 = new Customer("Марія", "Петренко");
        c2.addAccount(new Account(300.00));

        Customer c3 = new Customer("Олег", "Коваленко");
        c3.addAccount(new Account(15000.00));
        c3.addAccount(new Account(700.00));

        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);
    }

    private static void printHelp() {
        System.out.println("\nДоступні команди:");
        System.out.println("help або h       - показати цю довідку");
        System.out.println("customers або cus - список клієнтів");
        System.out.println("select <id>      - показати інформацію про клієнта");
        System.out.println("report           - повний звіт по всіх клієнтах");
        System.out.println("exit або e       - вихід з програми");
    }

    private static void listCustomers() {
        System.out.println("\nСписок клієнтів банку:");
        int i = 1;
        for (Customer c : bank.getCustomers()) {
            System.out.println(i + ". " + c.getFirstName() + " " + c.getLastName());
            i++;
        }
    }

    private static void selectCustomer(String input) {
        try {
            String[] parts = input.split(" ");
            int id = Integer.parseInt(parts[1]) - 1;
            Customer c = bank.getCustomer(id);
            if (c == null) {
                System.out.println("❌ Невірний номер клієнта!");
            } else {
                System.out.println("\nІнформація про клієнта:");
                System.out.println("Ім'я: " + c.getFirstName() + " " + c.getLastName());
                int i = 1;
                for (Account a : c.getAccounts()) {
                    System.out.println("  Рахунок " + i + ": баланс = " + a.getBalance());
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Невірний формат. Приклад: select 1");
        }
    }

    private static void printReport() {
        System.out.println("\n=== Звіт по клієнтах банку ===");
        int i = 1;
        for (Customer c : bank.getCustomers()) {
            System.out.println(i + ". " + c.getFirstName() + " " + c.getLastName());
            int j = 1;
            for (Account a : c.getAccounts()) {
                System.out.println("   Рахунок " + j + ": баланс = " + a.getBalance());
                j++;
            }
            i++;
        }
    }
}
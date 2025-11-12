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

public class Tuldem1 {

    // Простий клас для зберігання клієнтів банку
    static class Customer {
        String name;
        double balance;

        Customer(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return name + " — баланс: " + balance + " грн";
        }
    }

    private static final List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Початкові дані
        customers.add(new Customer("Іван Іванов", 5000));
        customers.add(new Customer("Марія Петренко", 12300));
        customers.add(new Customer("Олег Коваль", 7850));

        System.out.println("=== Банківська система CLI ===");
        System.out.println("Введіть 'help' для списку команд.");

        while (true) {
            System.out.print("bank> ");
            String command = sc.nextLine().trim().toLowerCase();

            if (command.equals("exit") || command.equals("e")) {
                System.out.println("Вихід із програми...");
                break;

            } else if (command.equals("help") || command.equals("h")) {
                System.out.println("""
                        Доступні команди:
                        help (h)    — показати цю довідку
                        list (l)    — список клієнтів
                        info <n>    — показати інформацію про клієнта №n
                        add         — додати нового клієнта
                        report (r)  — створити звіт по клієнтах
                        exit (e)    — вийти
                        """);

            } else if (command.equals("list") || command.equals("l")) {
                for (int i = 0; i < customers.size(); i++) {
                    System.out.println((i + 1) + ". " + customers.get(i).name);
                }

            } else if (command.startsWith("info")) {
                String[] parts = command.split(" ");
                if (parts.length < 2) {
                    System.out.println(" Вкажіть номер клієнта (наприклад: info 1)");
                } else {
                    try {
                        int index = Integer.parseInt(parts[1]) - 1;
                        if (index >= 0 && index < customers.size()) {
                            System.out.println(customers.get(index));
                        } else {
                            System.out.println(" Клієнта з таким номером не існує.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(" Некоректний номер.");
                    }
                }

            } else if (command.equals("add")) {
                System.out.print("Введіть ім'я клієнта: ");
                String name = sc.nextLine();
                System.out.print("Початковий баланс: ");
                double bal = sc.nextDouble();
                sc.nextLine(); // очищає буфер
                customers.add(new Customer(name, bal));
                System.out.println(" Клієнта додано.");

            } else if (command.equals("report") || command.equals("r")) {
                System.out.println("--- Звіт по клієнтах ---");
                for (Customer c : customers) {
                    System.out.println(c);
                }
                System.out.println("-------------------------");

            } else {
                System.out.println(" Невідома команда. Введіть 'help' для довідки.");
            }
        }

        sc.close();
    }
}

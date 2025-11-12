/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.util.*;

public class DataSource {
    private final String filename;

    public DataSource(String filename) {
        this.filename = filename;
    }

    public void loadData() {
        Bank.clear();
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("Data file not found: " + filename + "  — using default sample data.");
            loadSampleData();
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                // expected: First,Last,Type,Balance,Extra?
                String[] parts = line.split(",");
                if (parts.length < 4) continue;
                String first = parts[0].trim();
                String last = parts[1].trim();
                String type = parts[2].trim();
                double balance = Double.parseDouble(parts[3].trim());
                Customer c = Bank.addOrGetCustomer(first, last);
                if (type.equalsIgnoreCase("C")) {
                    double overdraft = 0.0;
                    if (parts.length >= 5) {
                        try { overdraft = Double.parseDouble(parts[4].trim()); } catch (Exception ex) {}
                    }
                    c.addAccount(new CheckingAccount(balance, overdraft));
                } else { // assume Savings
                    double rate = 0.0;
                    if (parts.length >= 5) {
                        try { rate = Double.parseDouble(parts[4].trim()); } catch (Exception ex) {}
                    }
                    c.addAccount(new SavingsAccount(balance, rate));
                }
            }
            System.out.println("Loaded data from " + filename + " (" + Bank.getNumOfCustomers() + " customers).");
        } catch (IOException e) {
            e.printStackTrace();
            loadSampleData();
        }
    }

    private void loadSampleData() {
        // fallback sample
        Customer c1 = Bank.addOrGetCustomer("John", "Doe");
        c1.addAccount(new CheckingAccount(1500, 200));
        c1.addAccount(new SavingsAccount(1000, 5));

        Customer c2 = Bank.addOrGetCustomer("Jane", "Smith");
        c2.addAccount(new CheckingAccount(800, 100));

        Customer c3 = Bank.addOrGetCustomer("Bob", "Brown");
        c3.addAccount(new SavingsAccount(1200, 3));
    }
}

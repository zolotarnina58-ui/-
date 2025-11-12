/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static final List<Customer> customers = new ArrayList<>();

    private Bank() {}

    public static void clear() { customers.clear(); }

    public static void addCustomer(Customer c) { customers.add(c); }

    public static Customer addOrGetCustomer(String first, String last) {
        for (Customer c : customers) {
            if (c.getFirstName().equalsIgnoreCase(first) && c.getLastName().equalsIgnoreCase(last)) {
                return c;
            }
        }
        Customer c = new Customer(first, last);
        customers.add(c);
        return c;
    }

    public static Customer getCustomer(int idx) {
        if (idx < 0 || idx >= customers.size()) return null;
        return customers.get(idx);
    }

    public static int getNumOfCustomers() { return customers.size(); }

    public static List<Customer> getCustomers() { return customers; }
}

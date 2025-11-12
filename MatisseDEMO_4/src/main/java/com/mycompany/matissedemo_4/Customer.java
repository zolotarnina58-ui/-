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

public class Customer {
    private final String firstName;
    private final String lastName;
    private final List<Account> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public void addAccount(Account a) { accounts.add(a); }

    public Account getAccount(int index) {
        if (index < 0 || index >= accounts.size()) return null;
        return accounts.get(index);
    }

    public int getNumberOfAccounts() { return accounts.size(); }

    public List<Account> getAccounts() { return accounts; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

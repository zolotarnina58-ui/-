/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
public class CheckingAccount extends Account {
    private double overdraft; // allowed overdraft amount

    public CheckingAccount(double balance) {
        this(balance, 0.0);
    }

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        this.overdraft = overdraft;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance + overdraft >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getOverdraft() { return overdraft; }

    @Override
    public String getAccountType() { return "Checking"; }

    @Override
    public String toString() {
        return String.format("%s: $%.2f, overdraft: $%.2f", getAccountType(), balance, overdraft);
    }
}


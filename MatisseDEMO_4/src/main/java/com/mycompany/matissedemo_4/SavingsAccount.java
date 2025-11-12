/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
public class SavingsAccount extends Account {
    private double interestRate; // percent

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getInterestRate() { return interestRate; }

    @Override
    public String getAccountType() { return "Savings"; }

    @Override
    public String toString() {
        return String.format("%s: $%.2f, interest rate: %.2f%%", getAccountType(), balance, interestRate);
    }
}

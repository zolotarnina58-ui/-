/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
public abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() { return balance; }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public abstract boolean withdraw(double amount);

    public abstract String getAccountType();

    @Override
    public String toString() {
        return String.format("%s: $%.2f", getAccountType(), getBalance());
    }
}
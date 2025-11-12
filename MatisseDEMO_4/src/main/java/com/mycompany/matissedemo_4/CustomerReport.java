/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
public class CustomerReport {
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("CUSTOMERS REPORT\n");
        sb.append("===============================\n");
        for (int i = 0; i < Bank.getNumOfCustomers(); i++) {
            Customer c = Bank.getCustomer(i);
            sb.append(String.format("%d) %s\n", i + 1, c.toString()));
            for (int j = 0; j < c.getNumberOfAccounts(); j++) {
                Account a = c.getAccount(j);
                sb.append(String.format("    #%d - %s\n", j, a.toString()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
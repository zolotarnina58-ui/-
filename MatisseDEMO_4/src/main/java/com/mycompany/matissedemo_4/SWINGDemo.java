/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matissedemo_4;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SWINGDemo extends JFrame {

    private final JComboBox<String> customerCombo;
    private final JComboBox<String> accountCombo;
    private final JButton showBtn;
    private final JButton reportBtn;
    private final JButton aboutBtn;
    private final JButton depositBtn;
    private final JButton withdrawBtn;
    private final JTextArea outputArea;
    private final JLabel statusBar;

    public SWINGDemo() {
        super("MyBank Clients");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(560, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(6,6));
        setResizable(false);

        // Top panel: combo and buttons
        JPanel top = new JPanel(new BorderLayout(6,6));
        JPanel selectPanel = new JPanel();
        customerCombo = new JComboBox<>();
        accountCombo = new JComboBox<>();
        accountCombo.setPreferredSize(new Dimension(220, 26));
        customerCombo.setPreferredSize(new Dimension(220, 26));
        selectPanel.add(customerCombo);
        selectPanel.add(accountCombo);

        JPanel buttonsPanel = new JPanel(new GridLayout(3,1,4,4));
        showBtn = new JButton("Show");
        reportBtn = new JButton("Report");
        aboutBtn = new JButton("About");
        buttonsPanel.add(showBtn);
        buttonsPanel.add(reportBtn);
        buttonsPanel.add(aboutBtn);

        top.add(selectPanel, BorderLayout.CENTER);
        top.add(buttonsPanel, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        // center text area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane sp = new JScrollPane(outputArea);
        sp.setPreferredSize(new Dimension(520, 240));
        add(sp, BorderLayout.CENTER);

        // right-bottom deposit/withdraw small panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel actionPanel = new JPanel();
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        actionPanel.add(depositBtn);
        actionPanel.add(withdrawBtn);
        bottomPanel.add(actionPanel, BorderLayout.EAST);

        statusBar = new JLabel(" Choose a client name and press 'Show' button");
        statusBar.setBorder(BorderFactory.createEmptyBorder(4,6,4,6));
        bottomPanel.add(statusBar, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // wire actions
        showBtn.addActionListener(e -> doShow());
        reportBtn.addActionListener(e -> doReport());
        aboutBtn.addActionListener(e -> doAbout());
        depositBtn.addActionListener(e -> doDeposit());
        withdrawBtn.addActionListener(e -> doWithdraw());
        customerCombo.addActionListener(e -> updateAccountList());

        // load data and fill combos
        DataSource ds = new DataSource("test.dat");
        ds.loadData();
        refreshCustomerCombo();
    }

    private void refreshCustomerCombo() {
        customerCombo.removeAllItems();
        for (Customer c : Bank.getCustomers()) {
            customerCombo.addItem(c.getFirstName() + " " + c.getLastName());
        }
        updateAccountList();
    }

    private void updateAccountList() {
        accountCombo.removeAllItems();
        int idx = customerCombo.getSelectedIndex();
        if (idx >= 0) {
            Customer c = Bank.getCustomer(idx);
            for (int i = 0; i < c.getNumberOfAccounts(); i++) {
                Account a = c.getAccount(i);
                accountCombo.addItem(String.format("#%d - %s", i, a.toString()));
            }
        }
    }

    private void doShow() {
        int idx = customerCombo.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Please select a customer.");
            return;
        }
        Customer c = Bank.getCustomer(idx);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<html><b>%s, customer #%d</b><br>---------------------------<br>",
                c.getFirstName() + " " + c.getLastName(), idx + 1));
        sb.append("<pre>");
        sb.append("Accounts:\n");
        for (int i = 0; i < c.getNumberOfAccounts(); i++) {
            Account a = c.getAccount(i);
            sb.append(String.format("#%d - %s\n", i, a.toString()));
        }
        sb.append("</pre></html>");
        // Use plain text area -> strip html or just format plain:
        StringBuilder plain = new StringBuilder();
        plain.append(c.getFirstName()).append(" ").append(c.getLastName()).append(", customer #").append(idx+1).append("\n");
        plain.append("---------------------------\n\n");
        plain.append("Accounts:\n");
        for (int i = 0; i < c.getNumberOfAccounts(); i++) {
            Account a = c.getAccount(i);
            plain.append(String.format("#%d - %s\n", i, a.toString()));
        }
        outputArea.setText(plain.toString());
        statusBar.setText("Showing information for " + c.getFirstName() + " " + c.getLastName());
        updateAccountList();
    }

    private void doReport() {
        CustomerReport cr = new CustomerReport();
        String report = cr.generateReport();
        outputArea.setText(report);
        statusBar.setText("Report generated");
    }

    private void doAbout() {
        JOptionPane.showMessageDialog(this,
                "MyBank GUI Demo\nAuthor: your name\nVersion: 1.0",
                "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private void doDeposit() {
        int custIdx = customerCombo.getSelectedIndex();
        int accIdx = accountCombo.getSelectedIndex();
        if (custIdx < 0 || accIdx < 0) {
            JOptionPane.showMessageDialog(this, "Select customer and account first.");
            return;
        }
        String s = JOptionPane.showInputDialog(this, "Enter deposit amount:", "100");
        if (s == null) return;
        try {
            double amount = Double.parseDouble(s);
            Customer c = Bank.getCustomer(custIdx);
            Account a = c.getAccount(accIdx);
            if (a.deposit(amount)) {
                doShow();
                statusBar.setText(String.format("Deposited $%.2f to %s", amount, c.toString()));
            } else {
                JOptionPane.showMessageDialog(this, "Deposit failed.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
        }
    }

    private void doWithdraw() {
        int custIdx = customerCombo.getSelectedIndex();
        int accIdx = accountCombo.getSelectedIndex();
        if (custIdx < 0 || accIdx < 0) {
            JOptionPane.showMessageDialog(this, "Select customer and account first.");
            return;
        }
        String s = JOptionPane.showInputDialog(this, "Enter withdraw amount:", "50");
        if (s == null) return;
        try {
            double amount = Double.parseDouble(s);
            Customer c = Bank.getCustomer(custIdx);
            Account a = c.getAccount(accIdx);
            if (a.withdraw(amount)) {
                doShow();
                statusBar.setText(String.format("Withdrew $%.2f from %s", amount, c.toString()));
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds or withdraw failed.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SWINGDemo d = new SWINGDemo();
            d.setVisible(true);
        });
    }
}
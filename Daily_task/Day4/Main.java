package com.example.bank.app;

import com.example.bank.model.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice Smith", 5000.0);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: " + account.getBalance());

        boolean success = account.withdraw(1500.0);

        System.out.println("Withdrawal Success: " + success);
        System.out.println("Final Balance: " + account.getBalance());
    }
}

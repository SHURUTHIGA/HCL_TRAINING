package com.example.atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmSimulator {

    private static final String PIN = "1234";
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> statement = new ArrayList<>();

    private static double balance = 1000.00;

    public static void main(String[] args) {

        System.out.println("=== ATM SIMULATOR ===");

        boolean authenticated = false;

        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine().trim();

            if (!enteredPin.matches("\\d{4}")) {
                System.out.println(
                    "Invalid input. Enter exactly 4 digits."
                );
                continue;
            }

            if (enteredPin.equals(PIN)) {
                authenticated = true;
                break;
            }

            System.out.println("Incorrect PIN.");
        }

        if (!authenticated) {
            System.out.println("Too many attempts. Access denied.");
            scanner.close();
            return;
        }

        int choice = 0;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid choice. Enter a number from 1 to 5."
                );
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.printf(
                        "Balance: Rs. %.2f%n", balance
                    );
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    double deposit = readAmount();

                    if (!Double.isFinite(deposit) || deposit <= 0) {
                        System.out.println(
                            "Invalid amount. Enter a valid amount greater than zero."
                        );
                        continue;
                    }

                    if (!Double.isFinite(balance + deposit)) {
                        System.out.println(
                            "Deposit exceeds the supported balance limit."
                        );
                        continue;
                    }

                    balance += deposit;
                    statement.add(
                        String.format("Deposit: +Rs. %.2f", deposit)
                    );

                    System.out.println("Deposit successful.");
                    System.out.printf(
                        "Updated balance: Rs. %.2f%n", balance
                    );
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawal = readAmount();

                    if (!Double.isFinite(withdrawal)
                            || withdrawal <= 0) {
                        System.out.println(
                            "Invalid amount. Enter a valid amount greater than zero."
                        );
                        continue;
                    }

                    if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                        continue;
                    }

                    balance -= withdrawal;
                    statement.add(
                        String.format(
                            "Withdrawal: -Rs. %.2f", withdrawal
                        )
                    );

                    System.out.println("Please collect your money.");
                    System.out.printf(
                        "Remaining balance: Rs. %.2f%n", balance
                    );
                    break;

                case 4:
                    System.out.println("\n--- MINI STATEMENT ---");

                    if (statement.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String transaction : statement) {
                            System.out.println(transaction);
                        }
                    }

                    System.out.printf(
                        "Current balance: Rs. %.2f%n", balance
                    );
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using the ATM!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Select 1 to 5."
                    );
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }

    private static double readAmount() {
        String input = scanner.nextLine().trim();

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

package com.example.bank.model;

import java.util.Objects;

public class BankAccount {
	private static int accountCounter = 1000;
	private String accountNumber;
	private String accountHolder;
	private double balance;

	public BankAccount() {
		this("Unknown Customer", 0.0);
	}

	public BankAccount(String accountHolder) {
		this(accountHolder, 0.0);
	}

	public BankAccount(String accountHolder, double initialBalance) {
		this.accountNumber = "ACC" + (++accountCounter);
		this.accountHolder = accountHolder;
		if (initialBalance >= 0) {
			this.balance = initialBalance;
		} else {
			this.balance = 0.0;
		}
	}

	public String getAccountNumber() { return accountNumber; }
	public String getAccountHolder() { return accountHolder; }
	public double getBalance() { return balance; }

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance += amount;
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BankAccount that = (BankAccount) o;
		return Objects.equals(accountNumber, that.accountNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}
}

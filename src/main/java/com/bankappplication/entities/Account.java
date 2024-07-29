package com.bankappplication.entities;

public abstract class Account {
    private static int idCounter = 1;
    protected int accountId;
    protected String name;
    protected double balance;

    public Account(String name, double initialBalance) {
        this.accountId = idCounter++;
        this.name = name;
        this.balance = initialBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Account.idCounter = idCounter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public abstract boolean withdraw(double amount);

    public abstract void calculateInterest();

    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Name: " + name + ", Balance: " + balance;
    }
}
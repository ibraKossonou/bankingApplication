package com.bankappplication.entities;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.05;
    private static final double MAX_WITHDRAWAL_AMOUNT = 1000;

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= MAX_WITHDRAWAL_AMOUNT && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest for this month is " + interest + " euros.");
    }
}

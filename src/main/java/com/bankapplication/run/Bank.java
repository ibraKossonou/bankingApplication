package com.bankapplication.run;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bankappplication.entities.Account;
import com.bankappplication.entities.CheckAccount;
import com.bankappplication.entities.SavingsAccount;

public class Bank {

	private Scanner scanner = new Scanner(System.in);
	private Map<Integer, Account> accounts = new HashMap<>();

	public static void main(String[] args) {
		Bank test = new Bank();
		test.launch();
	}

	public void launch() {
		while (true) {
			System.out.println("1. Create an account");
			System.out.println("2. Deposit money");
			System.out.println("3. Withdraw money");
			System.out.println("4. Display balance");
			System.out.println("5. Calcul interest");
			System.out.println("6. Quit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				depositMoney();
				break;
			case 3:
				withdrawMoney();
				break;
			case 4:
				displayBalance();
				break;
			case 5:
				calculateInterest();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			case 6:
				System.out.println("Goodbye!");
				return;
			}
		}

	}

	private void createAccount() {
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Enter the initial balance: ");
		double initialBalance = scanner.nextDouble();
		System.out.print("Chose the account type (1 for checking, 2 for saving): ");
		int type = scanner.nextInt();

		Account account;
		if (type == 1) {
			account = new CheckAccount(name, initialBalance);
		} else {
			account = new SavingsAccount(name, initialBalance);
		}
		accounts.put(account.getAccountId(), account);
	}

	private void depositMoney() {
		System.out.print("Enter your account identifier: ");
		int id = scanner.nextInt();
		System.out.print("Enter the amount to deposit: ");
		double amount = scanner.nextDouble();
		Account account = accounts.get(id);
		if (account != null) {
			account.deposit(amount);
			System.out.println(amount + " euros deposited into your account.");
		} else {
			System.out.println("Account not found.");
		}
	}

	public void depositMoney(int accountId, double amount) {
		Account account = accounts.get(accountId);
		if (account != null) {
			account.deposit(amount);
		}
	}

	public Account createAccount(String name, double initialBalance, int type) {
		Account account;
		if (type == 1) {
			account = new CheckAccount(name, initialBalance);
		} else {
			account = new SavingsAccount(name, initialBalance);
		}
		accounts.put(account.getAccountId(), account);
		return account;
	}

	public Account getAccount(int accountId) {
		return accounts.get(accountId);
	}

	private void withdrawMoney() {
		System.out.print("Enter your account identifier: ");
		int id = scanner.nextInt();
		System.out.print("Enter the amount to withdraw: ");
		double amount = scanner.nextDouble();

		Account account = accounts.get(id);
		if (account != null) {
			if (account.withdraw(amount)) {
				System.out.println(amount + " euros withdrawn from your account.");
			} else {
				System.out.println("Insufficient funds or withdrawal amount exceeds the limit.");
			}
		} else {
			System.out.println("Account not found.");
		}
	}

	public boolean withdrawMoney(int accountId, double amount) {
		Account account = accounts.get(accountId);
		if (account != null) {
			return account.withdraw(amount);
		}
		return false;
	}

	private void displayBalance() {
		System.out.print("Enter your account identifier: ");
		int id = scanner.nextInt();
		Account account = accounts.get(id);
		if (account != null) {
			System.out.println("Your balance is " + account.getBalance() + " euros.");
		} else {
			System.out.println("Account not found.");
		}
	}

	public double displayBalance(int accountId) {
		Account account = accounts.get(accountId);
		if (account != null) {
			return account.getBalance();
		}
		return -1;
	}

	private void calculateInterest() {
		System.out.print("Enter your account identifier: ");
		int id = scanner.nextInt();

		Account account = accounts.get(id);
		if (account != null) {
			if (account instanceof SavingsAccount) {
				account.calculateInterest();
			} else {
				System.out.println("Interest calculation is only applicable for savings accounts.");
			}
		} else {
			System.out.println("Account not found.");
		}
	}

	public void calculateInterest(int accountId) {
		Account account = accounts.get(accountId);
		if (account != null && account instanceof SavingsAccount) {
			account.calculateInterest();
		}
	}

}

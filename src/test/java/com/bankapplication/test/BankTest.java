package com.bankapplication.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bankapplication.run.Bank;
import com.bankappplication.entities.Account;

public class BankTest {

	private Bank bank;

	@BeforeEach
	public void setUp() {
		bank = new Bank();
	}

	@Test
	public void testCreateAndRetrieveAccount() {
		Account account = bank.createAccount("Alice Smith", 5000, 1);
		assertNotNull(account);
		assertEquals("Alice Smith", account.getName());
		assertEquals(5000, account.getBalance());
	}

	@Test
	public void testDepositMoney() {
		Account account=bank.createAccount("Alice Smith", 5000, 1);
		assertNotNull(account);
		assertEquals("Alice Smith", account.getName());
		assertEquals(5000, account.getBalance());
	}

	@Test
	public void testWithdrawMoney() {
		Account account =bank.createAccount("Charlie Brown", 2000, 1);
		assertTrue(bank.withdrawMoney(3, 500));
		assertEquals(1500, account.getBalance());
	}

	@Test
	public void testWithdrawMoneyExceedingBalance() {
		Account account = bank.createAccount("David Green", 1000, 1);
		assertFalse(bank.withdrawMoney(4, 1500));
		assertEquals(1000, account.getBalance());
	}

	@Test
	public void testCalculateInterestForSavingsAccount() {
		Account account = bank.createAccount("Eva White", 2000, 2);
		bank.calculateInterest(5);
		assertEquals(2000, account.getBalance());
	}

	@Test
	public void testCalculateInterestForCheckingAccount() {
		Account account = bank.createAccount("Frank Black", 3000, 1);
		bank.calculateInterest(6);
		assertEquals(3000, account.getBalance());
	}

}

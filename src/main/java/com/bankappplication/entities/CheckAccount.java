package com.bankappplication.entities;

public class CheckAccount extends Account{
	
	 public CheckAccount(String name, double initialBalance) {
	        super(name, initialBalance);
	    }

	    @Override
	    public boolean withdraw(double amount) {
	        if (balance >= amount) { // si le compte est supérieur au montant de retrtait
	            balance -= amount;
	            return true;
	        } else {
	            return false;
	        }
	    }

	    @Override
	    public void calculateInterest() {
	        // Pas de calcul parceque c'est compte standard
	    }

}

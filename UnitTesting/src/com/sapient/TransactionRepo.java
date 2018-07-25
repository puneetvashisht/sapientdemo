package com.sapient;

public interface TransactionRepo {
	
	boolean transact(int accountNumber, double amount);

}

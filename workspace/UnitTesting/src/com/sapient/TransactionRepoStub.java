package com.sapient;

public class TransactionRepoStub implements TransactionRepo{

	@Override
	public boolean transact(int accountNumber, double amount) {
		return true;
	}

}

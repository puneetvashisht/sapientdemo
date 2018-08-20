package com.sapient;

public class TransferService {
	
	TransferRepo repo; // = new TransferRepo();
	
	public TransferService(TransferRepo repo) {
		super();
		this.repo = repo;
	}

	public void transfer(long account1, long account2, double amount){
		repo.fetchAccount(account1);
		System.out.println("Transferin....");
	}

}

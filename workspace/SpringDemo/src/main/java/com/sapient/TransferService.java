package com.sapient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
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

	public TransferRepo getRepo() {
		return repo;
	}
	@Autowired
	public void setRepo(TransferRepo repo) {
		this.repo = repo;
	}
	
	

}

package com.sapient;

import org.springframework.stereotype.Component;

@Component
public class TransferRepo {
	
	public void fetchAccount(long account){
		System.out.println("Fetching account details for : " + account);
	}

}

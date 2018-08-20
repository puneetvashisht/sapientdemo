package com.sapient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TransferRepo {
	
	public void fetchAccount(long account){
		System.out.println("Fetching account details for : " + account);
	}

}

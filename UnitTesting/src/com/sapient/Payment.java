package com.sapient;

public class Payment {
	
	Sms sms;
	TransactionRepo repo;
	
	
	
	public Payment(TransactionRepo repo, Sms sms) {
		super();
		this.repo = repo;
		this.sms = sms;
	}



	public boolean fundsTransfer(int debitAccount, int creditAccount, double amount){
		
		
		// Credit
		boolean creditResult = repo.transact(creditAccount, amount);
		
		// Debit
		boolean debitResult = repo.transact(debitAccount, amount);
		
		//SMS 
		if(creditResult && debitResult && sms.sendMessage("Transfered: " + amount + " to your account: " + creditAccount)){
			return true;
		}
		
		
		return false;
		
	}
	
	public double balanceInquiry(int accountNumber){
		
		System.out.println("some logic");
		return accountNumber * 50;
		
	}

}

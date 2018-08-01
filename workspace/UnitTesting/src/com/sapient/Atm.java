package com.sapient;

public class Atm {

	public double cashWithdraw(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2000.00;
	}
}

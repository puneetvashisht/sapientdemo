package com.sapient;

public class Calc {
	
	public int sum(int ...values){
		int total = 0;
		for(int value: values){
			total+=value;
		}
		
		return total;
	}

	public int mul(int ...values) {
		int total = 1;
		for(int value: values){
			total*=value;
		}
		
		return total;
	}

	public int divide(int i, int j)  {
		if(j==0){
			throw new RuntimeException("Invalid Input!!");
		}
		return i/j;
	}
	public double divide(double i, double j) {
		return i/j;
	}

}

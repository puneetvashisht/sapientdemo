package com.sapient;

public class Engine {
	
	String make;
	int cc;

	public Engine(String make, int cc) {
		super();
		this.make = make;
		this.cc = cc;
	}


	@Override
	public String toString() {
		return "Engine [make=" + make + ", cc=" + cc + "]";
	}

	public void startEngine(){
		System.out.println("starting generic engine...");
		System.out.println(this);
		System.out.println(this.toString());
		
	}

}

package com.sapient;

public abstract class Vehicle {

	int maxSpeed;
	Engine e;
	
	
	public Vehicle(int maxSpeed, Engine e) {
		super();
		this.e = e;
		this.maxSpeed = maxSpeed;
	}


	public abstract void start();
	

}

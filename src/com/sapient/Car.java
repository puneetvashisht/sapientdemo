package com.sapient;

public class Car extends Vehicle {


	public Car(int maxSpeed, Engine engine){
//		this.maxSpeed = maxSpeed;
		super(maxSpeed, engine);
//		e = new Engine("Ford", 2200);
//		this.e  = engine;
	}

	@Override
	public void start() {
		e.startEngine();
		System.out.println("Starting car...");
		System.out.println("Can cruise at max: " + this.maxSpeed);
		
		
	}

}

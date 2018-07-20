package com.sapient;

public class Plane extends Vehicle {

	
	int maxAltitude;

	public Plane(int maxSpeed, int maxAltitude, PlaneEngine engine){
//		this.maxSpeed = maxSpeed;
		super(maxSpeed, engine);
		this.maxAltitude = maxAltitude;
//		e = new Engine("Ford", 2200);
//		this.e  = engine;
	}

	@Override
	public void start() {
		e.startEngine();
		System.out.println("Starting plane...");
		System.out.println("Can cruise at max: " + this.maxSpeed);
		System.out.println("Can fly at max: " + this.maxAltitude);
		
		
	}

	@Override
	public String toString() {
		return "Plane [e=" + e + ", maxAltitude=" + maxAltitude + "]";
	}
	
	

}

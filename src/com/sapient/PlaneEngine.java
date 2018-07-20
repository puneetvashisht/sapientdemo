package com.sapient;

public class PlaneEngine extends Engine {
	
	boolean booster;
	public PlaneEngine(String make, int cc, boolean booster) {
		super(make, cc);
		this.booster = booster;
			
	}
	
	@Override
	public void startEngine(){
		System.out.println("starting generic engine...");
		System.out.println(this);
		System.out.println(this.toString());
	}

}

package com.sapient;

public class Atm {
	
	int id;
	String location;
	
	
	public Atm(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}


	@Override
	public String toString() {
		return "Atm [id=" + id + ", location=" + location + "]";
	}

}

package com.sapient;

public class Branch {
	
	int id;
	String location;
	
	
	public Branch(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}


	@Override
	public String toString() {
		return "Branch [id=" + id + ", location=" + location + "]";
	}

}

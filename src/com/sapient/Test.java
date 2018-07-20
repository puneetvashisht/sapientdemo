package com.sapient;

public class Test {

	public static void main(String[] args) {
//		Vehicle v = new Vehicle(300);
		Engine e = new Engine("Ford", 2200);
		Car car = new Car(300, e);
		car.start();
		
		PlaneEngine pe = new PlaneEngine("Boeing", 220000, true);
		Plane plane = new Plane(1000,10000,  pe);
		plane.start();

	}

}

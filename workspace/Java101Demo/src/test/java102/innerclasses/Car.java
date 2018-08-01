package test.java102.innerclasses;

public abstract class Car {
	
	private String manufacturer;
	public abstract void start();
	public abstract int getBatteryPower();
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	

}

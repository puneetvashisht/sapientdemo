package test.java102.innerclasses;

public class TestCar {

	public static void main(String[] args) {
		Car car = new Car(){
			int batteryPower;
			
			
			public int getBatteryPower() {
				return batteryPower;
			}


			@Override
			public void start() {
				
				this.batteryPower-=1000;
			}
			
		};
		System.out.println(car.getBatteryPower());
		car.start();
		System.out.println(car.getBatteryPower());

	}

}

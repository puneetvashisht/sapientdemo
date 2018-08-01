package java102.synchronizers;

import java.util.concurrent.Semaphore;

public class SomeRepository {
	int totalConnections = 10;
	Semaphore semaphore = new Semaphore(7);
	
	public void getConnection() throws Exception{
		semaphore.acquire();
		System.out.println("Permits available: " + semaphore.availablePermits());
		if(totalConnections<=0){
			throw new Exception("DB connection not availble");
		}
		totalConnections = totalConnections - 1;
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got Connection!! Left: " +totalConnections);;
		totalConnections = totalConnections + 1;
		semaphore.release();
	}

}

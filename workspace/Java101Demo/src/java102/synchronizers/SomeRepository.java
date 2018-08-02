package java102.synchronizers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SomeRepository {
	AtomicInteger  totalConnections = new AtomicInteger(10);
	Semaphore semaphore = new Semaphore(7);
	
	public void getConnection() throws Exception{
		semaphore.acquire();
		System.out.println("Permits available: " + semaphore.availablePermits());
		if(totalConnections.get()<=0){
			throw new Exception("DB connection not availble");
		}
//		totalConnections = totalConnections - 1;
		totalConnections.decrementAndGet();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got Connection!! Left: " +totalConnections);;
		totalConnections.incrementAndGet();
		semaphore.release();
	}

}

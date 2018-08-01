package java102.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadPoolDemp {

	public static void main(String[] args) throws InterruptedException {
		
		List<Runnable> runnables = new ArrayList<>();

		Thread t = new WorkerThread(runnables);
		t.start();
		
		synchronized(runnables){
			runnables.add(new Runnable(){
				@Override
				public void run() {
					System.out.println("First Runnable");
				}	
			});
			runnables.notify();
			runnables.add(new Runnable(){
				@Override
				public void run() {
					System.out.println("Second Runnable");
				}	
			});
			runnables.notify();
		}
		
		Thread.sleep(2000);

	}

}

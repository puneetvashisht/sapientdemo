package java102.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Callable<Integer> task = new MyCallable();
		Future<Integer> future = service.submit(task);
		
		try {
			Integer result = future.get();
			System.out.println("Result from thread:" + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

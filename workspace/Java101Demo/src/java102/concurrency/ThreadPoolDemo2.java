package java102.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadPoolDemo2 {
	

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Future<Integer>> futures = new ArrayList<>();
		for(int i=0;i<5; i++){
			Callable<Integer> task = new FactorialCallable(i);
			Future<Integer> result = service.submit(task);
			futures.add(result);
		}
		for(Future<Integer> f : futures){
			int result;
			try {
				result = f.get();
				System.out.println(result);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}

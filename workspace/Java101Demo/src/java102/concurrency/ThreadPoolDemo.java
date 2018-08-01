package java102.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolDemo {
	
	private static class TestTask1 implements Runnable {
		@Override
		public void run() {
				System.out.println("A by " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		
//		ExecutorService service = Executors.newFixedThreadPool(2);
		Executor executor = new ThreadPoolExecutor(2, 4,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2),new  MyRejectedExecutionHandler());
		
		for(int i=0;i<7;i++){
			executor.execute(new TestTask1());
		}

	}

}

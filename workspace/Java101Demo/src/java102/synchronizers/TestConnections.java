package java102.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable{
	SomeRepository repo;

	public MyRunnable(SomeRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName());
		try {
			repo.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}

public class TestConnections {
	
	public static void main(String[] args) {
		SomeRepository repo = new SomeRepository();
		ExecutorService service = Executors.newFixedThreadPool(20);
		for(int i=0;i<20;i++){
			MyRunnable runnable = new MyRunnable(repo);
			service.submit(runnable);
		}
		
		
	}

}

package java102.threads;

public class Counter implements Runnable {
	
	volatile int count;
	
	public Counter(int count) {
		super();
		this.count = count;
	}
	
	@Override
	public  void run(){
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		count = count + 1;
		System.out.println(count + " : "+ Thread.currentThread().getName());
	}

}

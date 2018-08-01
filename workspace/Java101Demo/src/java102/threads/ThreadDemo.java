package java102.threads;

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Executed by : " + Thread.currentThread().getName());
		
	}
	
}


public class ThreadDemo {
	
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
		System.out.println("Main Thread " + Thread.currentThread().getName());
	}

}

package java102.threads;



public class JoinDemo {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Being run by " + Thread.currentThread().getName());		
			}
			
		});
		t.start();
		System.out.println(System.currentTimeMillis());
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		System.out.println("Main Thread " + Thread.currentThread().getName());
	}

}

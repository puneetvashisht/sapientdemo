package java102.threads;

public class CounterTest {
	
	public static void main(String[] args) {
		Counter counter = new Counter(0);
		System.out.println("Before: " + counter.count);
		for(int i=0; i<10; i++){
			
			Thread t = new Thread(counter);
			t.start();
			
		}
		
	}

}

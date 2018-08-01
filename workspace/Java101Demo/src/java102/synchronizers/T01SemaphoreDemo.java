package java102.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T01SemaphoreDemo {
	public static void main(String[] args) {
		final Pool pool = new Pool();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				try {
					while (true) {
						String item;
						System.out.printf("%s acquiring %s%n", name,
								item = pool.getItem());
//						Thread.sleep(2000 + (int) (Math.random() * 100));
						Thread.sleep(7000);
						
						System.out.printf("%s putting back %s%n", name, item);
						pool.putItem(item);
					}
				} catch (InterruptedException ie) {
					System.out.printf("%s interrupted%n", name);
				}
			}
		};
		ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE + 15];
		for (int i = 0; i < executors.length; i++) {
			executors[i] = Executors.newSingleThreadExecutor();
			executors[i].execute(r);
		}
	}
}

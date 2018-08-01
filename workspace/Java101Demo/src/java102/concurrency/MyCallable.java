package java102.concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		return 2;
	}

}

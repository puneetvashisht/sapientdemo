package java102.concurrency;

import java.util.concurrent.Callable;

public class FactorialCallable  implements Callable<Integer>{
	Integer i;

	public FactorialCallable(Integer i) {
		super();
		this.i = i;
	}


	@Override
	public Integer call() throws Exception {
		int fact = 1;
		for(int i=this.i; i>0; i--){
			fact*=i;
		}
		return fact;
	}

}

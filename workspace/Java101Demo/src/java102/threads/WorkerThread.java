package java102.threads;

import java.util.List;

public class WorkerThread extends Thread{
	
	List<Runnable> runnables;
	
	public WorkerThread(List<Runnable> runnables) {
		super();
		this.runnables = runnables;
	}



	@Override
	public void run(){
		while(true){
			synchronized(runnables){
				if(runnables.isEmpty()){
					try {
						runnables.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				runnables.remove(0).run();
			}
			
		}
		
	}
}

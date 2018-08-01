package java102.threads;

import java.util.ArrayList;
import java.util.List;

public class IncrementSalaries {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		for(int i=0;i<10; i++){
			Employee emp = new Employee(i+1, "Name-" +i, 1000.0*i);
			employees.add(emp);
		}
		List<Thread> threads = new ArrayList<>();
		
		long startTime = System.currentTimeMillis();
		for(Employee employee: employees){
			Runnable runnable = new SalaryTask(employee);
			Thread t = new Thread(runnable);
			threads.add(t);
			t.start();
			
		}
		
		for(Thread t : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(System.currentTimeMillis() - startTime);
		
		
		
		
		System.out.println("Main Thread " + Thread.currentThread().getName());
	
	}

}

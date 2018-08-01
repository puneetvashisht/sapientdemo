package java102.threads;

public class SalaryTask implements Runnable{
	
//	Employee emp = new Employee(12, "Sonia", 44343.45);

	Employee emp;
	public SalaryTask(Employee employee){
		emp = employee;
	}
	@Override
	public void run() {
		double newSalary = emp.incrementSalary(2000);
//		System.out.println("This can process Salary Task" + Thread.currentThread().getName());
		System.out.println("New Salary " + newSalary + " by " + Thread.currentThread().getName());
		
	}

}

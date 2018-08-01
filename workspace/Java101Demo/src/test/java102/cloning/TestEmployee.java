package test.java102.cloning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import java102.cloning.Address;
import java102.cloning.Employee;

public class TestEmployee {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
	public void test() {
		Employee emp = new Employee(12, "Ravi", 34343.33);
		Employee clonedEmp = null;
		try {
			clonedEmp = (Employee)emp.clone();
			System.out.println(clonedEmp);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		assertEquals(clonedEmp, emp);
	}
	
//	@Test
	public void testDeepCloning() {
		Address address = new Address(232, "Marathalli", "Bengaluru");
		Employee emp = new Employee(12, "Ravi", 34343.33);
		emp.setAddress(address);
		Employee clonedEmp = null;
		try {
			clonedEmp = (Employee)emp.clone();
			System.out.println(clonedEmp);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(clonedEmp.getAddress());
		System.out.println(emp.getAddress());
		System.out.println(clonedEmp.getAddress() != emp.getAddress());
//		assertNotEquals(clonedEmp.getAddress(), emp.getAddress());
		assertTrue(clonedEmp.getAddress() != emp.getAddress());
		assertEquals(clonedEmp, emp);
	}
	
	@Test
	public void testPerformance(){
		Address address = new Address(232, "Marathalli", "Bengaluru");
		Employee emp = new Employee(12, "Ravi", 34343.33);
		emp.setAddress(address);
		List<Employee> employees = new ArrayList<>();
		long startTime = System.nanoTime();
		
		final int iterations = 10000000;
		for(int i=0;i<iterations;i++){
			Employee clonedEmp = null;
			try {
				clonedEmp = (Employee)emp.clone();
				employees.add(clonedEmp);
//				System.out.println(clonedEmp);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}	
		}
		long endTime = System.nanoTime();
		long cloneTime = endTime - startTime;
		System.out.println("Cloining Time in nano sec :" + cloneTime);
		
		long startTimeCC = System.nanoTime();
		List<Employee> employeesWithCC = new ArrayList<>();
		for(int i=0;i<iterations;i++){
			Employee newEmp = new Employee(emp);
			employeesWithCC.add(newEmp);
			
		}
		long endTimeCC = System.nanoTime();
		long copyTime = endTimeCC - startTimeCC;
		System.out.println("Copy Time in nano sec :" + copyTime);
		
	}

}

package test.java102.cloning;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import java102.cloning.Employee;
import java102.cloning.SortEmployees;

public class TestSalaryComparator {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		
		Employee emp1 = new Employee(12, "Ravi", 34343.33);
		Employee emp2= new Employee(12, "Ravi", 14343.33);
		Employee emp3 = new Employee(12, "Ravi", 24343.33);
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);employees.add(emp2);employees.add(emp3);
		List<Employee> sortedEmployees = SortEmployees.sortBySalary(employees);
		System.out.println(sortedEmployees);
	}

}

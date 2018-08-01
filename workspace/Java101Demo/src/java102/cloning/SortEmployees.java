package java102.cloning;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployees {
	
	public static List<Employee> sortBySalary(List<Employee> employees){
		 Collections.sort(employees, new Comparator<Employee>(){

			 @Override
				public int compare(Employee o1, Employee o2) {
					return o1.salary.compareTo(o2.salary);
				}
			 
		 });
		 return employees;
	}

}

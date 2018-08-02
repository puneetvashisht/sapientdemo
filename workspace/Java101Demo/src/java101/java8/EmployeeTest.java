package java101.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeTest {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			new Employee(1, "Ravi", "Barnes"),
			new Employee(12, "Ravi", "Charles"),
			new Employee(14, "Virat", "Kohli"),
			new Employee(51, "David", "Carol"),
			new Employee(61, "James", "Barnes"),
			new Employee(15, "Priya", "Thakur")		
		);
		
		Collections.sort(employees, (e1,e2)->e1.getLastName().compareTo(e2.lastName));
		
//		Condition condition = new Condition() {	
//			@Override
//			public boolean test() {
//				return true;
//			}
//		};
//		printConditionally(employees, condition);
		printConditionally(employees, (e)->e.getFirstName().startsWith("R"));
		printConditionally(employees, (e)->e.getLastName().startsWith("C"));
		
		printConditionally(employees, (e)->e.getFirstName().startsWith("R"), (e)->System.out.println(e.firstName));
		printConditionally(employees, (e)->e.getFirstName().startsWith("R"), (e)->System.out.println(e));
	}
	
	public static void printConditionally(List<Employee> employees, Predicate<Employee> predicate){
		for(Employee e: employees){
			if(predicate.test(e)){
				System.out.println(e);
			}
			
		}
	}
	
	public static void printConditionally(List<Employee> employees, Predicate<Employee> predicate, Consumer<Employee> consumer){
		for(Employee e: employees){
			if(predicate.test(e)){
				consumer.accept(e);
			}
			
		}
	}

}

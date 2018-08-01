package java102.annotations;

import java102.annotations.Todo.Items;

@Todo(value="Any value",item=Items.PHONES)
public class Employee {
	
	@Todo(value="Any value")
	private int someField;
	
	@Todo(value="Any value" , item=Items.SCREENS)
	public void test(){
		
	}

}

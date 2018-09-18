package com.sapient.entity.inheritancedemo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RegularEmployee_TPC")
//@DiscriminatorValue(value="R_EMPS")
public class RegularEmployee extends EmployeeID{
	
	double salary;
	
	public RegularEmployee(){
		
	}

	public RegularEmployee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + ", id=" + id + ", name=" + name + "]";
	}
	
	

}

package com.sapient.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="my_employee")
@NamedQueries(value = { 
		@NamedQuery(name = "findAllEmployees", query = "select e from Employee e"),
		@NamedQuery(name = "findEmployeesByName", query = "select e from Employee e where e.name=:x")
})

public class Employee  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	@Column(name="emp_salary")
	double salary;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Address> addresses;
	
	@Embedded
	EmployeeDetail employeeDetail;
	
	@Version
	int versionId;
	

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name, double salary) {
		this(name);
		this.salary = salary;
	}
	
	
	public Employee(String name, double salary, EmployeeDetail employeeDetail) {
		super();
		this.name = name;
		this.salary = salary;
		this.employeeDetail = employeeDetail;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
	

}

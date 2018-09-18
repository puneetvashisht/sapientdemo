package com.sapient.repos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sapient.entity.Employee;

public class EmployeeRepo {
	
	// Create Entity Manager Factory
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatedemo");
	
	
	public Employee findEmployee(int id){
		EntityManager em = emf.createEntityManager();
		
		Employee emp = em.find(Employee.class, id);
		em.close();
		return emp;
	}
	
	public void addEmployee(Employee emp){
		//Entity Manager --> physical connection to db
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if(emp.getName() == null){
			tx.rollback();
		}
		// Create a query to insert an employee
		em.persist(emp);
		
		tx.commit();
		em.close();
		
		
		
	}
	
	public static void main(String[] args) {
		EmployeeRepo repo = new EmployeeRepo();
		Employee emp = new Employee("Ravi");
//		emp.setId(2);
//		repo.addEmployee(emp);
		Employee emp2 = repo.findEmployee(3);
		System.out.println(emp2);
	}

}

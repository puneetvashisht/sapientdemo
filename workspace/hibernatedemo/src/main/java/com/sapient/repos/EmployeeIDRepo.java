package com.sapient.repos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sapient.entity.Address;
import com.sapient.entity.Employee;
import com.sapient.entity.EmployeeDetail;
import com.sapient.entity.inheritancedemo.EmployeeID;
import com.sapient.entity.inheritancedemo.RegularEmployee;



public class EmployeeIDRepo {
	
	// Create Entity Manager Factory
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatedemo");
	
	
	
	public void addEmployee(EmployeeID emp){
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
		EmployeeIDRepo repo = new EmployeeIDRepo();
		
		EmployeeID emp = new EmployeeID("Ravi");
		repo.addEmployee(emp);
		
		RegularEmployee rEmp = new RegularEmployee("Priya", 34343.3);
		repo.addEmployee(rEmp);
		
		
	}

}

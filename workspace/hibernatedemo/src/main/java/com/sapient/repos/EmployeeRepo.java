package com.sapient.repos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sapient.entity.Address;
import com.sapient.entity.Employee;
import com.sapient.entity.EmployeeDetail;

public class EmployeeRepo {
	
	// Create Entity Manager Factory
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatedemo");
	
	public List<Employee> findAllEmployees(){
		EntityManager em = emf.createEntityManager();
		TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
		List<Employee> employees  = query.getResultList();

		em.close();
		return employees;
	}
	
	public List<Employee> findEmployeesByNamme(String name){
		EntityManager em = emf.createEntityManager();
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.name=:x", Employee.class);
		query.setParameter("x", name);
		List<Employee> employees  = query.getResultList();
		

		em.close();
		return employees;
	}
	
	public Employee findEmployee(int id){
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		System.out.println(emp.getAddresses());
		em.close();
		return emp;
	}
	
	public void deleteEmployee(int id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee emp = em.find(Employee.class, id);
		em.remove(emp);
		
		tx.commit();
		em.close();
	}
	
	
	public void updateEmployee(int id, String newName){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee emp = em.find(Employee.class, id);
		
	
		
		tx.commit();
		em.close();
		
		emp.setName(newName);
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
		Address add1 = new Address("GK", "New Delhi");
		Address add2 = new Address("Matundu", "Nairobi");
		
		EmployeeDetail edetails = new EmployeeDetail(3);
		Employee emp = new Employee("Priya", 343354.34, edetails);
		List<Address> addresses = new ArrayList<>();
		addresses.add(add1);addresses.add(add2);
 		
		emp.setAddresses(addresses);
//		emp.setId(2);
		repo.addEmployee(emp);
//		Employee emp2 = repo.findEmployee(8);
//		System.out.println(emp2);
//		System.out.println(emp2.getAddresses());
//		repo.updateEmployee(4, "Rosh");
//		repo.deleteEmployee(4);
		
//		List<Employee> emps = repo.findAllEmployees();
//		System.out.println(emps);
		
//		List<Employee> emps = repo.findEmployeesByNamme("Rosh");
//		System.out.println(emps);
		
	}

}

package com.sapient.repos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sapient.entity.Address;
import com.sapient.entity.Employee;
import com.sapient.entity.EmployeeDetail;

public class EmployeeRepo {

	// Create Entity Manager Factory
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatedemo");

	public List<Employee> findAllEmployees() {
		EntityManager em = emf.createEntityManager();
//		TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
		TypedQuery<Employee> query =em.createNamedQuery("findAllEmployees", Employee.class);
		List<Employee> employees = query.getResultList();

		em.close();
		return employees;
	}

	public List<Employee> findEmployeesByNamme(String name) {
		EntityManager em = emf.createEntityManager();
//		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.name=:x", Employee.class);
		TypedQuery<Employee> query = em.createNamedQuery("findEmployeesByName", Employee.class);
		
		query.setParameter("x", name);
		List<Employee> employees = query.getResultList();

		em.close();
		return employees;
	}

	public Employee findEmployee(int id) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
//		System.out.println(emp.getAddresses());
		em.close();	
		
		//Detached Object
		emp.setName("Ravi");
		
		//Merge it back to a persistent object
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(emp);
		
		tx.commit();
		em.close();	
		
		
		return emp;
	}

	public void deleteEmployee(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Employee emp = em.find(Employee.class, id);
		em.remove(emp);

		tx.commit();
		em.close();
	}

	public void updateEmployee(int id, String newName) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee emp = em.find(Employee.class, id);	
		emp.setName(newName);	
		tx.commit();
		em.close();

	}

	public void addEmployee(Employee emp) {
		// Entity Manager --> physical connection to db
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (emp.getName() == null) {
			tx.rollback();
		}
		// Create a query to insert an employee
		em.persist(emp);

		tx.commit();
		em.close();

	}

	public void test() {
		EntityManager entitymanager = emf.createEntityManager();
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Employee> from = criteriaQuery.from(Employee.class);

		// select all records
		System.out.println("Select all records");
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();

		for (Object o : resultlist) {
			Employee e = (Employee) o;
			System.out.println("EID : " + e.getId() + " Ename : " + e.getName());
		}

		// Ordering the records
		System.out.println("Select all records by follow ordering");
		CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("name")));
		TypedQuery<Object> typedQuery1 = entitymanager.createQuery(select);
		List<Object> resultlist1 = typedQuery1.getResultList();

		for (Object o : resultlist1) {
			Employee e = (Employee) o;
			System.out.println("EID : " + e.getId() + " Ename : " + e.getName());
		}

	}

	public void testNativeQuery() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery("SELECT a.id, a.name FROM my_employee a");
		List<Object[]> employees = q.getResultList();

		for (Object[] a : employees) {
			System.out.println("ID " + a[0] + " Name" + a[1]);	
		}
		em.close();
	}

	public static void main(String[] args) {
		EmployeeRepo repo = new EmployeeRepo();
////		repo.test();
//		repo.updateEmployee(13, "Ravi");
		
//		 Address add1 = new Address("GK", "New Delhi");
//		 Address add2 = new Address("Matundu", "Nairobi");
//		
//		 EmployeeDetail edetails = new EmployeeDetail(3);
//		 Employee emp = new Employee("Priya", 343354.34, edetails);
//		 List<Address> addresses = new ArrayList<>();
//		 addresses.add(add1);addresses.add(add2);
//		
//		 emp.setAddresses(addresses);
//		// emp.setId(2);
//		 repo.addEmployee(emp);
		 Employee emp2 = repo.findEmployee(8);
		 System.out.println(emp2);
//		 System.out.println(emp2.getAddresses());
//		 System.out.println(emp2.getAddresses());
		 
		// repo.deleteEmployee(4);

//		 List<Employee> emps = repo.findAllEmployees();
//		 System.out.println(emps);

//		 List<Employee> emps = repo.findEmployeesByNamme("Ravi");
//		 System.out.println(emps);

	}

}

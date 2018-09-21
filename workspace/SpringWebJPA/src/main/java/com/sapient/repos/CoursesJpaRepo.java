package com.sapient.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sapient.models.CourseEntity;


@Repository
public class CoursesJpaRepo {
	
	@PersistenceContext
	EntityManager em;

	
	public CourseEntity getCourseEntityById(int id){
		return em.find(CourseEntity.class, id);     
	 }

	
	public List<CourseEntity> findAllCourses() {
		
		TypedQuery<CourseEntity> query =em.createNamedQuery("findAllCourses", CourseEntity.class);
		List<CourseEntity> employees = query.getResultList();
		em.close();
		return employees;
	}

	@Transactional
	public void addCourse(CourseEntity course){
		em.persist(course);
		
	}


	
	
	
	
	
	
	
}

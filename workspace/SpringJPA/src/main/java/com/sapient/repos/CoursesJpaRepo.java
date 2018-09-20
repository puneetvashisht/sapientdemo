package com.sapient.repos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sapient.entities.CourseEntity;

@Repository
public class CoursesJpaRepo {
	
	@PersistenceContext
	EntityManager em;

	
	public CourseEntity getCourseEntityById(int id){
		return em.find(CourseEntity.class, id);     
	 }

	@Transactional
	public void addCourse(CourseEntity course) {
		em.persist(course);
	}


}

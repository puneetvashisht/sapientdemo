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

		return employees;
	}
	
	public CourseEntity findCourseById(int id) {		
		return em.find(CourseEntity.class, id);
	}
	
	@Transactional
	public void deleteCourse(int id) {		
		CourseEntity courseEntity = em.find(CourseEntity.class, id);
		em.remove(courseEntity);
	}
	
	@Transactional
	public void updateCourse(CourseEntity newCourseEntity){	
		em.merge(newCourseEntity);
	}

	@Transactional
	public void addCourse(CourseEntity course){
		em.persist(course);
		
	}


	
	
	
	
	
	
	
}

package com.sapient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sapient.entities.CourseEntity;
import com.sapient.repos.CoursesJpaRepo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCourseJpaRepo {
	
	@Autowired
	CoursesJpaRepo repo;
	
//	@Test
	public void testFindById(){
		CourseEntity course = repo.getCourseEntityById(2);
		System.out.println(course);
	}
	
	@Test
	public void testAddCourse(){
		CourseEntity course = new CourseEntity("JS", "Core library");
		repo.addCourse(course);
		System.out.println(course);
	}

}

package com.sapient;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sapient.repos.Course;
import com.sapient.repos.CoursesRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCourseRepository {

	@Autowired
	CoursesRepo repo;
	

	@Test
	public void testFindACourse() {
		Course course = repo.getCourseByName();
		assertEquals(course.getName(), "Angular");
	}
	
	@Test
	public void testFindAllCourses() {
		List<String> courses = repo.getAllCourses();
		System.out.println(courses);
		assertEquals(courses.size(), 2);
	}
	
	

	

}

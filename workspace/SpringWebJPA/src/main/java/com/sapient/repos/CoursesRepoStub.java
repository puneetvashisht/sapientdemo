package com.sapient.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sapient.models.Course;

@Component("stub")
public class CoursesRepoStub implements ICoursesRepo {
	
	
	List<Course> courses = new ArrayList<>();
	{
		courses.add(new Course(12, "TestCourse", "Test Summary"));
		courses.add(new Course(123, "DummyCourse", "Dummy Summary"));
	}

	@Override
	public List<Course> findAllCourses() {
		
		
		return courses;
	}

	@Override
	public List<Course> findCourse(String name) {
//		return new Course(12, "TestCourse", "Test Summary");
		
		List<Course> courses =  this.courses.stream()
	    .filter(course -> {
	    	System.out.println(course.getName());
	    	System.out.println(name);
	    	return course.getName().equals(name);
	    })
	    .collect(Collectors.toList());
		
		System.out.println("Filtered courses" + courses);
		return courses;
	}

	@Override
	public Course addCourse(Course course) {
		this.courses.add(course);
		return course;
	}

}

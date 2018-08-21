package com.sapient.repos;

import java.util.ArrayList;
import java.util.List;

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
	public Course findCourse(String name) {
		return new Course(12, "TestCourse", "Test Summary");
	}

}

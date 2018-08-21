package com.sapient;

import org.springframework.stereotype.Component;

@Component("CoursesJPARepo")
public class CoursesJPARepo implements CourseRepo{

	public void findCourses() {
		System.out.println("Find courses in Repo - JPA!!");
		
	}

}

package com.sapient;

import org.springframework.stereotype.Component;

@Component("CoursesJDBCRepo")
public class CoursesJDBCRepo implements CourseRepo{

	public void findCourses() {
		System.out.println("Find courses in Repo!!");
		
	}

}

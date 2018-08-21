package com.sapient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CourseService {
	
	
	@Autowired
	@Qualifier("CoursesJDBCRepo")
	CourseRepo repo;
	
	
	public void findCourses(){
		repo.findCourses();
		System.out.println("find courses in service");
	}

}

package com.sapient.springbootdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CourseRESTController {


	
	@RequestMapping(path="/courses/{courseid}", method=RequestMethod.GET)
	public CourseEntity fetchCourseById(@PathVariable("courseid")int id){
		System.out.println("REST Controller code invoked..");
		CourseEntity course = new CourseEntity("Test", "Spring boot test");
		course.setId(id);
		return course;
	}
	
	
}

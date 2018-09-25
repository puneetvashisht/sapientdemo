package com.sapient.springbootdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CourseRESTController {

	@Autowired
	ICourseRepo courseRepo;

	@RequestMapping(path="/course/find/{courseid}", method=RequestMethod.GET)
	public CourseEntity fetchCourseById(@PathVariable("courseid")int id){
		System.out.println("REST Controller code invoked..");
		CourseEntity course = courseRepo.getOne(id);
		System.out.println(course);
		return course;
	}
	
	@RequestMapping(path="/course/{name}", method=RequestMethod.GET)
	public CourseEntity fetchCourseByName(@PathVariable("name")String name){
		CourseEntity course = courseRepo.findByName(name);
		return course;
	}
	
	@RequestMapping(path="/course", method=RequestMethod.GET)
	public List<CourseEntity> fetchAllCourses(){
		List<CourseEntity> courses = courseRepo.findAll();
		return courses;
	}
	
	
}

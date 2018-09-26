package com.sapient.springbootdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CourseRESTController {

	@Autowired
	ICourseRepo courseRepo;
	
	@Autowired
	CourseService courseService;
	

	@RequestMapping(path="/courses/{courseid}", method=RequestMethod.GET)
	public CourseEntity fetchCourseById(@PathVariable("courseid")int id){
		CourseEntity course = courseRepo.getOne(id);
		System.out.println(course);
		return course;
	}
	
	@RequestMapping(path="/courses", method=RequestMethod.GET)
	public CourseEntity fetchCourseByName(@RequestParam(value="name") String name){
		CourseEntity course = courseRepo.findByName(name);
		return course;
	}
	
	@RequestMapping(path="/courses", method=RequestMethod.POST)
	public CourseEntity addCourse(@RequestBody CourseEntity course){
		courseService.addCourse(course);
		return course;
	}
	
	
	
	@RequestMapping(path="/coursesall", method=RequestMethod.GET)
	public List<CourseEntity> fetchAllCourses(){
		List<CourseEntity> courses = courseRepo.findAll();
		return courses;
	}
	
	
}

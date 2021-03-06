package com.sapient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.common.CourseNotFoundException;
import com.sapient.models.CourseEntity;
import com.sapient.repos.CoursesJpaRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CourseRESTController {

	@Autowired
	CoursesJpaRepo jpaRepo;
	
	@RequestMapping(path="/courses", method=RequestMethod.GET)
	public List<CourseEntity> fetchCourses(){
		System.out.println("REST Controller code invoked..");
		List<CourseEntity> courses = jpaRepo.findAllCourses();
		System.out.println(courses);
		return courses;
	}
	
	@RequestMapping(path="/courses/{courseid}", method=RequestMethod.GET)
	public CourseEntity fetchCourseById(@PathVariable("courseid")int id){
		System.out.println("REST Controller code invoked..");
		CourseEntity course = jpaRepo.findCourseById(id);
		System.out.println(course);
		if(course == null){
			throw new CourseNotFoundException(id + ": not found");
		}
		return course;
	}
	@RequestMapping(path="/courses/{courseid}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("courseid")int id){
		System.out.println("REST Controller code invoked..");
		jpaRepo.deleteCourse(id);
	}
	
	
	@RequestMapping(path="/courses", method=RequestMethod.POST)
	public ResponseEntity<Void> addCourse(@RequestBody CourseEntity course){
		System.out.println("REST Controller code invoked..");
		jpaRepo.addCourse(course);
		if(course.getName().equals("Angular")){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
//		return course;
	}
	
	@RequestMapping(path="/courses", method=RequestMethod.PUT)
	public CourseEntity updateCourse(@RequestBody CourseEntity course){
		System.out.println("REST Controller code invoked..");
		jpaRepo.updateCourse(course);
		return course;
	}
	
	
	
	
}

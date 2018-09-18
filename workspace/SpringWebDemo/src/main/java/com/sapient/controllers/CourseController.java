package com.sapient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.models.Course;
import com.sapient.repos.ICoursesRepo;

@Controller
public class CourseController {
	
	@Autowired
	@Qualifier("stub")	
	ICoursesRepo repo;
	
	
	@RequestMapping(path="/courses", method=RequestMethod.GET)
	public String fetchCourses(Model model){
		System.out.println("Controller code invoked..");
		// fetch courses from db.. repo
		List<Course> courses = repo.findAllCourses();
		System.out.println(courses);
		
		model.addAttribute("courses", courses);
		return "courseview";
		
	}
	
	
	@RequestMapping(path="/course", method=RequestMethod.GET)
	public String fetchCourses(Model model, @RequestParam("name") String name){
		System.out.println("Controller code invoked.." + name);
//		System.out.println(id);
		List<Course> courses = repo.findCourse(name);
		
		model.addAttribute("courses", courses);
		return "courseview";
		
	}
	
	
	@RequestMapping(path="/course", method=RequestMethod.POST)
	public String addCourse(Model model,@ModelAttribute Course course){
//		Course course = new Course(0, name, summary);
		
		
		Course addedCourse =  repo.addCourse(course);
		// addd course to db.. repo		
		model.addAttribute("message", "Course successfully added!!");
		model.addAttribute("courses", addedCourse);
		return "courseview";
		
	}

}

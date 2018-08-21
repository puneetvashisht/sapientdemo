package com.sapient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {
	
	
	@RequestMapping(path="/courses", method=RequestMethod.GET)
	public String fetchCourses(Model model){
		
		System.out.println("Controller code invoked..");
		model.addAttribute("courseName", "Angular");
		return "courseview";
		
	}

}

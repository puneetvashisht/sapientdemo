package com.sapient.springbootdemo;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	ICourseRepo courseRepo;
	
	@Autowired
	LogService logService;
	
	@Transactional(value=TxType.REQUIRED)
//	Tx1
	public void addCourse(CourseEntity course){
		courseRepo.save(course);
		logService.log(course.getName());
		if(course.getName().length()< 3){
			throw new RuntimeException("Course name must be 3 chars-- rollback");
		}
		
		
	}

}

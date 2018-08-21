package com.sapient.repos;

import java.util.List;

import com.sapient.models.Course;

public interface ICoursesRepo {
	public List<Course> findAllCourses() ;
	public Course findCourse(String name);
}

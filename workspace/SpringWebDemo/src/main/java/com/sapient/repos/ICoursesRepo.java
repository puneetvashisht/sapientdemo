package com.sapient.repos;

import java.util.List;

import com.sapient.models.Course;

public interface ICoursesRepo {
	public List<Course> findAllCourses() ;
	public List<Course> findCourse(String name);
	public Course addCourse(Course course);
}

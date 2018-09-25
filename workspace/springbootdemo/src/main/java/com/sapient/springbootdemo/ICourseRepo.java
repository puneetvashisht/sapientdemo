package com.sapient.springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends JpaRepository<CourseEntity, Integer>{

		public CourseEntity findByName(String name);
//		public CourseEntity findById(Integer id);
}

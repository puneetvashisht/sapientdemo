package com.sapient.repos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesRepo {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CoursesRepo(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	public Course getCourseByName(){
		   String SQL = "select * from course where name='Angular'";
		   RowMapper<Course> courseRowMapper = new CourseRowMapper();
		   Course course =  jdbcTemplate.queryForObject(SQL,courseRowMapper);
		   System.out.println(course);
		   return course;
		   
	   }
	
	public List<String> getAllCourses(){
		String SQL = "select name from course";
		List<String> courses = jdbcTemplate.queryForList(SQL, String.class);
		return courses;
	}

}

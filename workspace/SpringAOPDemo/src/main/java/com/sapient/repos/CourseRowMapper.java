package com.sapient.repos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseRowMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course(rs.getInt("id"), rs.getString("name"), rs.getString("summary"));
	    return course;
	}

}

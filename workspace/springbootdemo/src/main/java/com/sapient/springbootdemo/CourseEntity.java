package com.sapient.springbootdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="course")
@NamedQuery(name = "findAllCourses", query = "select e from CourseEntity e")
@XmlRootElement
public class CourseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String summary;
	
	public CourseEntity(){
		
	}
	public CourseEntity(String name, String summary) {
		super();
		this.name = name;
		this.summary = summary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", summary=" + summary + "]";
	}
	
	

}

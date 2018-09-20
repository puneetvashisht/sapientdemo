package com.sapient.repos;


public class Course {
	
	int id;
	String name;
	String summary;
	
	public Course(){
		
	}
	public Course(int id, String name, String summary) {
		super();
		this.id = id;
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

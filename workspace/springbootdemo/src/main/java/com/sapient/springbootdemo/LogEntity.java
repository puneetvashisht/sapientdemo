package com.sapient.springbootdemo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
//@NamedQuery(name = "findAllCourses", query = "select e from CourseEntity e")
@XmlRootElement
public class LogEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	@Temporal(TemporalType.TIMESTAMP)
	Date date = new Date();
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LogEntity(){
		
	}
	public LogEntity(String name) {
		super();
		this.name = name;
	
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

	@Override
	public String toString() {
		return "LogEntity [id=" + id + ", name=" + name + "]";
	}
	
	

}

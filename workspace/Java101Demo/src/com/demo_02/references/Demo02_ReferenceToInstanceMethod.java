package com.demo_02.references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Student{
	public String name;
	public float marks;
	public Student(String name, float marks){
		this.name = name;
		this.marks = marks;
	}
	public float getMarks(){
		//get student marks
		return this.marks;
	}
	
}
public class Demo02_ReferenceToInstanceMethod {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Miley", 63.24f));
		studentList.add(new Student("Carl", 71.88f));
		studentList.add(new Student("Jhon", 92.19f));
		
		
		// Using an anonymous class
		List<Float> studentMarksAnonumous = new Demo02_ReferenceToInstanceMethod().getStudentMarks(studentList, new Function<Student, Float>() {
		  public Float apply(Student std) { // The object
		    return std.getMarks(); // The method
		  }
		});
		
		
		// Using a lambda expression
		List<Float> studentMarksLambda = new Demo02_ReferenceToInstanceMethod().getStudentMarks(studentList, s -> s.getMarks());
		
		// Using a method reference
		List<Float> studentMarksMethodReference = new Demo02_ReferenceToInstanceMethod().getStudentMarks(studentList, Student::getMarks);
		
		
		System.out.println(studentMarksAnonumous);
		System.out.println(studentMarksLambda);
		System.out.println(studentMarksMethodReference);
	}
	
	public List<Float> getStudentMarks(
			  List<Student> l, Function<Student, Float> f) {
			    List<Float> results = new ArrayList<>();
			    for(Student s : l) {
			      results.add(f.apply(s));
			    }
			    return results;
			}
}
package com.demo_02.references;

@FunctionalInterface
interface Referable{
	public void referenceFromHere(String msg);
}

public class Demo01_ReferenceToStaticMethod {
	public static void staticMethod(String msg) {
	      System.out.println(msg);
	   }

	public void implement() {
	      // Anonymous class.
	      Referable demo1 = new Referable() {
	         @Override
	         public void referenceFromHere(String msg) {
	            Demo01_ReferenceToStaticMethod.staticMethod(msg);
	         }
	      };
	      demo1.referenceFromHere("Anonumous class calling static method");

	      // Lambda implementaion.
	      Referable demo2 = (msg) -> Demo01_ReferenceToStaticMethod.staticMethod(msg);
	      demo2.referenceFromHere("Lambda calling static method.");

	      // Method reference.
	      //Referable is FunctionalInterface, right side definition will be body of the abstract body
	      Referable demo3 = Demo01_ReferenceToStaticMethod::staticMethod;
 	      demo3.referenceFromHere("Static Method reference");
	   }
	public static void main(String[] args) {
		new Demo01_ReferenceToStaticMethod().implement();
	}
}
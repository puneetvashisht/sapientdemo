package com.demo_02.references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Demo03_ReferenceToInstanceConstructorReference {
	public static void main(String[] args) {
		// Using an anonymous class
		Supplier<List<String>> sAnonymous = new Supplier() {
			@Override
		  public List<String> get() {
		    return new ArrayList<String>();
		  }
		};
		List<String> listAnonymous = sAnonymous.get();

		// Using a lambda expression
		Supplier<List<String>> sLambda = () -> new ArrayList<String>();
		List<String> listLambda = sLambda.get();

		// Using a method reference
		Supplier<List<String>> sReference = ArrayList::new;
		List<String> listReference = sReference.get();
		
		System.out.println(listAnonymous);
		System.out.println(listLambda);
		System.out.println(listReference);
	}
}
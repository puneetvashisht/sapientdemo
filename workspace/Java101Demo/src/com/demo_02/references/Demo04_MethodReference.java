package com.demo_02.references;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo04_MethodReference {
	public static void main(String[] args) {
	    List<String> nameList = Arrays.asList("Blue Whale", "Elephant", "Giraffe");
	    Consumer<String> action = System.out::println;
	    action = new Demo04_MethodReference()::println;
	    action = Demo04_MethodReference::staticPrintln;
	    
	    nameList.forEach(action);
	}
	
	public void println(String name){
		System.out.println(name);
	}
	public static void staticPrintln(String name){
		System.out.println(name);
	}
}

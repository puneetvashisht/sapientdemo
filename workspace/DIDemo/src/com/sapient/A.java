package com.sapient;

public class A {
	
	B b; // = new B();
	C c; // = new C();
	
	public A(B b, C c){
		this.b = b;
		this.c = c;
	}

	public void execute(){
		b.execute();
		c.execute();
		System.out.println("Executing A");
	}
	
}

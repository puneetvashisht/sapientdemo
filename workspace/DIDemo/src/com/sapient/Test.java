package com.sapient;

public class Test {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		
		A a = new A(b, c);
		a.execute();

	}

}

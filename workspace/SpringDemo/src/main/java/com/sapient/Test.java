package com.sapient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		B b = new B();
//		C c = new C();
		
//		A a = new A(b, c);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		A a = context.getBean(A.class);
//		a.execute();
		


		
//		TransferService service = (TransferService) context.getBean("transferService");
		TransferService service = context.getBean(TransferService.class);
		TransferService service1 = context.getBean(TransferService.class);
//		
		System.out.println(service == service1);
		service.transfer(123l, 3454, 34535.33);
		
		DataSource ds  = context.getBean(DataSource.class);
		System.out.println(ds);
		

	}

}

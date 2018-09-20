package com.sapient.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(void com.sapient.service.*Service.*(..))")
	public void printParams(JoinPoint jp){
		Object args[] = jp.getArgs();
		//Logging of parameters
		for(Object arg: args){
			System.out.println("" +jp.getSignature().getName() +  arg);
		}
		
		System.out.println("Printing Params start--------");
//		System.out.println(l);
//		System.out.println(i);
//		System.out.println(d);
		System.out.println("Printing Params end --------");
	}

}
